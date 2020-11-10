package com.test.sampleproject.pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.databinding.DataBindingUtil;

import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import com.test.sampleproject.R;
import com.test.sampleproject.databinding.ActivityPdfBinding;

import java.io.File;

import timber.log.Timber;

public class PdfActivity extends AppCompatActivity {

    private ActivityPdfBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pdf);
        start();
    }

    private void start() {
        Toast.makeText(this, "SHOW PDF", Toast.LENGTH_SHORT).show();
        String text = "kotlin";
        File file = new File(new File(Environment.getExternalStorageDirectory(), "Download"), text + ".pdf");
//        String url = "file:///storage/emulated/0/Download/kotlin.pdf";
        String url = "http://115.68.106.108:8080/hermes/resource/store/44/17/f4eb38fa90845c128420bbd577e5461e9bd1/document.pdf";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        Uri uri = Uri.parse(url);
        Uri uri1 = Uri.fromFile(new File(url));
        Timber.d(file.getPath());
        Timber.d(file.getName());
//        mBinding.pdfView.fromFile(file);
        mBinding.pdfView.fromUri(uri1)
//        mBinding.pdfView.fromAsset("Kotlin.pdf")
//                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
//                .onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
//                .onDrawAll(onDrawListener)
//                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
//                .onPageChange(onPageChangeListener)
//                .onPageScroll(onPageScrollListener)
//                .onError(onErrorListener)
//                .onPageError(onPageErrorListener)
//                .onRender(onRenderListener) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
//                .onTap(onTapListener)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .invalidPageColor(Color.WHITE) // color of page that is invalid and cannot be loaded
                .load();
    }

}
