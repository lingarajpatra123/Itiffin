package in.itiffin.itiffin.model;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by Lingaraj on 11/5/2015.
 */
public class ImageClass  {

    int image_id;
    String url;
    String product_id;
    ImageAdapter imageAdapter;
    Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public ImageAdapter getImageAdapter() {
        return imageAdapter;
    }

    public void setImageAdapter(ImageAdapter imageAdapter) {
        this.imageAdapter = imageAdapter;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }


    public void loadImage(ImageAdapter imageAdapter)
    {
        this.imageAdapter=imageAdapter;
        if(url!=null && url.equals(""))
        {
            new ImageLoadTask().execute(url);
        }
    }

    private class ImageLoadTask extends AsyncTask<String,String,Bitmap>{



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            try{
                Bitmap b =  ImageService.getBitmapFromURLWithScale(params[0]);
                return  b;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap bitmap1) {
            if (bitmap != null) {
                //Log.i("ImageLoadTask", "Successfully loaded " + name + " image");
                bitmap=bitmap1;
                if (bitmap != null) {
                    // WHEN IMAGE IS LOADED NOTIFY THE ADAPTER
                    imageAdapter.notifyDataSetChanged();
                }
            } else {
               // Log.e("ImageLoadTask", "Failed to load " + name + " image");
            }        }
    }
}
