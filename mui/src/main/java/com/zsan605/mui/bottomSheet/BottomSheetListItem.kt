package com.zsan605.mui.bottomSheet

import android.graphics.Typeface
import android.graphics.drawable.Drawable

class BottomSheetListItem(var text: CharSequence, tag: String) {
    var image: Drawable? = null
    var imageRes = 0
    var imageSkinTintColorAttr = 0
    var imageSkinSrcAttr = 0
    var textSkinColorAttr = 0
    var tag = ""
    var hasRedPoint = false
    var isDisabled = false
    var typeface: Typeface? = null
    fun image(image: Drawable?): BottomSheetListItem {
        this.image = image
        return this
    }

    fun image(imageRes: Int): BottomSheetListItem {
        this.imageRes = imageRes
        return this
    }

    fun skinTextColorAttr(attr: Int): BottomSheetListItem {
        textSkinColorAttr = attr
        return this
    }

    fun skinImageTintColorAttr(attr: Int): BottomSheetListItem {
        imageSkinTintColorAttr = attr
        return this
    }

    fun skinImageSrcAttr(attr: Int): BottomSheetListItem {
        imageSkinSrcAttr = attr
        return this
    }

    fun redPoint(hasRedPoint: Boolean): BottomSheetListItem {
        this.hasRedPoint = hasRedPoint
        return this
    }

    fun disabled(isDisabled: Boolean): BottomSheetListItem {
        this.isDisabled = isDisabled
        return this
    }

    fun typeface(typeface: Typeface?): BottomSheetListItem {
        this.typeface = typeface
        return this
    }

    init {
        this.tag = tag
    }
}
