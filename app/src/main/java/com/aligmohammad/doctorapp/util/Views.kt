package com.aligmohammad.doctorapp.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.aligmohammad.doctorapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar

/**
 * a function to quickly display a toast message
 * @param message
 * @see Context.toast
 * @sample toast("Message")
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * a function to show the progress bar
 * @see ProgressBar
 */
fun ProgressBar.show() {
    visibility = View.VISIBLE
}

/**
 * a function to hide the progress bar
 * @see ProgressBar
 */
fun ProgressBar.hide() {
    visibility = View.GONE
}

/**
 *
 * @receiver View
 * @param message String
 */
fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

/**
 * Get progress drawable
 *
 * @param context
 * @return a CircularProgressDrawable
 */
fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}


/**
 * Load image
 *
 * @param uri
 * @param progressDrawable
 */
fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions().placeholder(progressDrawable).error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}


///**
// * Load image
// *
// * @param view
// * @param url
// */
//@BindingAdapter("android:imageUrl")
//fun loadImage(view: ImageView, url: String?) {
//    view.loadImage(url, getProgressDrawable(view.context))
//}
//
//
///**
// * Load background color
// *
// * @param view
// * @param url
// */
//@BindingAdapter("android:backgroundUrl")
//fun loadBackgroundColor(view: LinearLayout, url: String?) {
//    Glide.with(view)
//        .asBitmap()
//        .load(url)
//        .into(object: CustomTarget<Bitmap>() {
//            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                Palette.from(resource).generate { palette ->
//                    val color = palette?.lightMutedSwatch?.rgb ?: 0
//                    view.setBackgroundColor(color)
//                }
//            }
//            override fun onLoadCleared(placeholder: Drawable?) {
//            }
//        })
//}