package dk.cccontractors.www.swing.snapshot;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JViewport;

import dk.cccontractors.www.swing.BasicPlot;

public class SnapShot {
	
	/** Note 1
	 * Documentation is missing for this issue! Must find.
	 *  */

	/** Note 2
	 * Documentation is missing for this issue! Must find.
	 *  */
    // This method returns true if the specified image has transparent pixels
	
	/**
	 * http://forums.sun.com/thread.jspa?threadID=5303661
	 * http://java.sun.com/docs/books/tutorial/2d/images/saveimage.html
	 * */	
		
	public void snapShot(JPanel target)
	{
		//test writing frame as image to pngencoded file on disk.
		JPanel _target = target;
	    Rectangle rect = _target.getVisibleRect();
		int w = rect.width;
	    int h = rect.height;

//		int w = 0;
//	    int h = 0;
//	    for(Component comp : _target.getComponents())
//	    {
//	    	if (comp instanceof Plot)
//	    	{
//			    Rectangle rect = comp.getBounds();
//				w = rect.width;
//			    h = rect.height;
//	    	}
//	    	
//	    };
	    
	    
	    //	int w = target.getWidth();
	    //    int h = target.getHeight();
	    if (w <= 0 || h <= 0) {
	        System.out.println("component size is zero");
	    } else {
	        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g = image.createGraphics();
	        _target.paint(g);
	        g.dispose();
	        try {
	            //boolean success = ImageIO.write(image, "jpeg", new File("test.jpeg"));
	            boolean success = ImageIO.write(image, "png", new File("test.png"));
	            System.out.println("success=" + success);
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	    }	
	}	
	
	
	
	
		public static boolean hasAlpha(Image image) {
	        // If buffered image, the color model is readily available
	        if (image instanceof BufferedImage) {
	            BufferedImage bimage = (BufferedImage)image;
	            return bimage.getColorModel().hasAlpha();
	        }
	    
	        // Use a pixel grabber to retrieve the image's color model;
	        // grabbing a single pixel is usually sufficient
	         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
	        try {
	            pg.grabPixels();
	        } catch (InterruptedException e) {
	        }
	    
	        // Get the image's color model
	        ColorModel cm = pg.getColorModel();
	        return cm.hasAlpha();
	    }
		public void snapShot(JFrame target)
		{
			//test writing frame as image to pngencoded file on disk.
			JFrame _target = target;
//		    Rectangle rect = _target.getBounds();
//			int w = rect.width;
//		    int h = rect.height;
			
			JRootPane root = _target.getRootPane();
			
			
			int w = 0;
		    int h = 0;
		    for(Component comp : root.getComponents())
		    {
		    	if (comp instanceof BasicPlot)
		    	{
				    Rectangle rect = comp.getBounds();
					w = rect.width;
				    h = rect.height;
		    	}
		    	
		    };
		    
		    
		    
		    //	int w = target.getWidth();
		    //    int h = target.getHeight();
		    if (w <= 0 || h <= 0) {
		        System.out.println("component size is zero");
		    } else {
		        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		        //BufferedImage image = new BufferedImage(w, h, BufferedImage);
		        Graphics2D g = image.createGraphics();
		        _target.paint(g);
		        g.dispose();
		        try {
		            //boolean success = ImageIO.write(image, "jpeg", new File("test.jpeg"));
		            boolean success = ImageIO.write(image, "png", new File("test.png"));
		            System.out.println("success=" + success);
		        } catch(IOException e) {
		            e.printStackTrace();
		        }
		    }	
		}
		
		public void snapShot3(Component target)
		{
			//test writing frame as image to pngencoded file on disk.
			Component _target = target;
//		    Rectangle rect = _target.getBounds();
//			int w = rect.width;
//		    int h = rect.height;
			
			//JRootPane root = _target.getRootPane();
			
			
			int w = 0;
		    int h = 0;

		    	if (_target instanceof BasicPlot)
		    	{
				    
		    		Container cont = ((BasicPlot) _target).getParent();
		    		
		    		if (cont instanceof JViewport)
		    		{
		    		
		    			//Rectangle rect = ((BasicPlot) _target).getVisibleRect();
					
			    		Rectangle rect = ((JViewport) cont).getVisibleRect();
			    		w = rect.width;
					    h = rect.height;
		    		}

		    		
		    	}
	    		if (_target instanceof JFrame)
	    		{
	    		
	    			
	    			JPanel content = (JPanel) (  (JFrame) _target).getContentPane();
	    			
		    		Rectangle rect = content.getVisibleRect();
		    		w = rect.width;
				    h = rect.height;
	    		}
		    	
//		    	if (_target instanceof JLayeredPane)
//		    	{
//				    Rectangle rect = _target.getBounds();
//					w = rect.width;
//				    h = rect.height;
//		    	}
		    	
		   
		    
		    
		    
		    //	int w = target.getWidth();
		    //    int h = target.getHeight();
		    if (w <= 0 || h <= 0) {
		        System.out.println("component size is zero");
		    } else {
		        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		        //BufferedImage image = new BufferedImage(w, h, BufferedImage);
		        Graphics2D g = image.createGraphics();
		        _target.paint(g);
		        g.dispose();
		        try {
		            //boolean success = ImageIO.write(image, "jpeg", new File("test.jpeg"));
		            boolean success = ImageIO.write(image, "png", new File("test.png"));
		            System.out.println("success=" + success);
		        } catch(IOException e) {
		            e.printStackTrace();
		        }
		    }	
		}	

        public static final float[] SHARPEN3x3 = {
            0.f,  -1.f,  0.f,
            -1.f,  5.f, -1.f,
            0.f,  -1.f,  0.f};
        
        
        public static final float[] SHARPEN_EXT = { .25f, -2, .25f,
                   -2, 10,  -2,
                  .25f, -2, .25f };
		
		public void snapShot2(JFrame frame)
		{

		    //test writing frame as image to pngencoded file on disk.
			//JFrame _target = target;
//		    Rectangle rect = frame.getBounds();
//			int w = rect.width;
//		    int h = rect.height;
		    
			int w = 0;
		    int h = 0;
		    for(Component comp : frame.getComponents())
		    {
		    	if (comp instanceof Panel)
		    	{
				    Rectangle rect = comp.getBounds();
					w = rect.width;
				    h = rect.height;
		    	}
		    	
		    };
		    
		    
		    
		    //	int w = target.getWidth();
		    //    int h = target.getHeight();
		    if (w <= 0 || h <= 0) {
		        System.out.println("component size is zero");
		    } else {
		        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
   
		        Graphics2D g = image.createGraphics();
		        frame.paint(g);
		        g.dispose();
		        
		        BufferedImage target =
		        	  new java.awt.image.BufferedImage( image.getWidth(),
		        	       image.getHeight(),image.getType() );	        
				
		        g = target.createGraphics();
		        g.drawImage( image, null,0,0 );
		        g.dispose();
		        
		        
		        //Kernel kernel = new Kernel(3, 3, SHARPEN_EXT );
		        
		        Kernel kernel = new Kernel(3, 3, normalizeKernel(SHARPEN_EXT) );
		        
		        
		        ConvolveOp cop = new ConvolveOp(kernel,
		                                        ConvolveOp.EDGE_NO_OP,
		                                        null);
		        
		        
		        image = cop.filter(target, image);
		        
		        image = cop.filter(image, null);
		        
		        g.dispose();
		        //BufferedImage image = new BufferedImage(w, h, BufferedImage);

		        try {
		            //boolean success = ImageIO.write(image, "jpeg", new File("test.jpeg"));
		            boolean success = ImageIO.write(image, "png", new File("test.png"));
		            System.out.println("success=" + success);
		        } catch(IOException e) {
		            e.printStackTrace();
		        }
		    }	
		}
		private float[] normalizeKernel( float[] ar ) {

			  int n =0;
			  for (int i = 0; i < ar.length; i++)
			  n += ar[i];
			  for (int i = 0; i < ar.length; i++)
			  ar[i] /= n;

			  return ar;
			}
}
