package cubex.mahesh.asynctasktest_aug7am

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get.setOnClickListener({
                var task = MyTask(iview)
                task.execute()
        })

        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

    } // onCreate
    class MyTask(var iview:ImageView) : AsyncTask<Unit, Unit, Unit>()
    {
        var isr:InputStream? = null
        override fun doInBackground(vararg p0: Unit?) {
            var u = URL("http://celogique.com/wp-content/uploads/2016/11/3c0ff08c0c85d72ed67907d4198922ba_large.jpeg")
            isr =    u.openStream()
        }
        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            var bmp = BitmapFactory.decodeStream(isr)
            iview.setImageBitmap(bmp)
        }
    }
}  // MainActivity
