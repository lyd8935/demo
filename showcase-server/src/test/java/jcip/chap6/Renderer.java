package jcip.chap6;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import jcip.chap5.LaunderThrowable;
import jcip.chap6.Renderer.ImageData;

public abstract class Renderer {
	private final ExecutorService executor;

	public Renderer(ExecutorService executor) {
		this.executor = executor;
	}
	
	public void renderPage(CharSequence source){
		List<ImageInfo> info = scanForImageInfo(source);
		CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
		for(final ImageInfo imageInfo : info){
			completionService.submit(new Callable<ImageData>() {
				@Override
				public ImageData call() throws Exception {
					return imageInfo.downloadImage();
				}
			});
		}
		
		renderText(source);
		try {
			for(int t = 0, n = info.size(); t < n; t++){
				Future<ImageData> f;
				f = completionService.take();
				ImageData imageData = f.get();
				renderImage(imageData);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			throw LaunderThrowable.launderThrowable(e.getCause());
		}	
	}
	
	abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
	
	interface ImageData {
	}

	interface ImageInfo {
		ImageData downloadImage();
	}
}
