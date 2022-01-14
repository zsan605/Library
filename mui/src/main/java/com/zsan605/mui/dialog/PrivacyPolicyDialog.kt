package com.zsan605.mui.dialog

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.text.Spannable
import android.view.LayoutInflater
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.LinkBuilder
import com.klinker.android.link_builder.TouchableMovementMethod
import com.zsan605.mui.R
import com.zsan605.mui.databinding.DialogPrivacyPolicyBinding

class PrivacyPolicyDialogBuilder(private val context: Context) {

    companion object {
        fun builder(context: Context): PrivacyPolicyDialogBuilder {
            return lazy {
                PrivacyPolicyDialogBuilder(context)
            }.value
        }

    }

    private val mBind =
        DialogPrivacyPolicyBinding.inflate(LayoutInflater.from(context), null, false)
    private var mTitle: String = "用户隐私政策"
    private var mPositiveText: String = "同意"
    private var mNegativeText: String = "不同意"
    private var mLinks = mutableListOf<Link>()
    private lateinit var mPositiveListener: DialogInterface.OnClickListener
    private lateinit var mNegativeListener: DialogInterface.OnClickListener

    fun addTitle(title: String): PrivacyPolicyDialogBuilder {
        mTitle = title
        return this
    }

    fun setUserProtocolUrl(link: String, linkTextColor: Int): PrivacyPolicyDialogBuilder {
        mLinks.add(genLink(context.getString(R.string.dialog_user_protocol_link_text), link, linkTextColor))
        return this
    }

    fun setUserProtocolUrl(link: String): PrivacyPolicyDialogBuilder {
        mLinks.add(genLink(context.getString(R.string.dialog_user_protocol_link_text), link, null))
        return this
    }

    fun setPrivacyPolicyUrl(link: String): PrivacyPolicyDialogBuilder {
        mLinks.add(genLink(context.getString(R.string.dialog_privacy_policy_link_text), link, null))
        return this
    }

    fun setPrivacyPolicyUrl(link: String, linkTextColor: Int): PrivacyPolicyDialogBuilder {
        mLinks.add(genLink(context.getString(R.string.dialog_privacy_policy_link_text), link, linkTextColor))
        return this
    }

    fun setPositiveButton(listener: DialogInterface.OnClickListener): PrivacyPolicyDialogBuilder {
        mPositiveListener = listener
        return this
    }

    fun setPositiveButton(
        text: String,
        listener: DialogInterface.OnClickListener
    ): PrivacyPolicyDialogBuilder {
        mPositiveListener = listener
        mPositiveText = text
        return this
    }

    fun setNegativeButton(listener: DialogInterface.OnClickListener): PrivacyPolicyDialogBuilder {
        mNegativeListener = listener
        return this
    }

    fun setNegativeButton(
        text: String,
        listener: DialogInterface.OnClickListener
    ): PrivacyPolicyDialogBuilder {
        mNegativeListener = listener
        mNegativeText = text
        return this
    }


    private fun genLink(linkText: String, urlStr: String, linkTextColor: Int?): Link {

        var link = Link(linkText)
            .setHighlightAlpha(.4f)
            .setUnderlined(false)
            .setBold(true)
            .setOnClickListener {
                val uri: Uri = Uri.parse(urlStr)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }

        if (linkTextColor != null) {
            link.setTextColor(linkTextColor)
//            link.setTextColorOfHighlightedLink(Color.RED)
        }

        return link

    }


    fun build(): MaterialAlertDialogBuilder {

        LinkBuilder
            .on(mBind.msgTv)
            .addLinks(mLinks)
            .build()

        return MaterialAlertDialogBuilder(context)
            .setCancelable(false)
            .setTitle(mTitle)
            .setView(mBind.root)
            .setPositiveButton(mPositiveText, mPositiveListener)
            .setNegativeButton(mNegativeText, mNegativeListener)
    }
}