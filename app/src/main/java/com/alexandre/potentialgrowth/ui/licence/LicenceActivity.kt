package com.alexandre.potentialgrowth.ui.licence

import android.os.Build
import android.os.Bundle
import android.text.Html
import com.alexandre.potentialgrowth.R
import com.alexandre.potentialgrowth.ui.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_licence.*

class LicenceActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_licence)
        super.onCreate(savedInstanceState)

        nav_view.menu.getItem(4).isChecked = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            licenceTxt.text = Html.fromHtml(getString(R.string.licence_txt), Html.FROM_HTML_MODE_LEGACY)
        }
        else {
            @Suppress("DEPRECATION")
            licenceTxt.text = Html.fromHtml(getString(R.string.licence_txt))
        }
    }
}