package com.flexath.msixteenassignment.views.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.flexath.msixteenassignment.R

class RoundedProfileImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var cornerRadius = 0f
    private val path = Path()

    companion object {
        private const val DEFAULT_BORDER_WIDTH = 8.0f
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
    }

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedProfileImage) {
            cornerRadius = getDimension(R.styleable.RoundedProfileImage_cornerRadius,0f)
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle,cornerRadius,cornerRadius,Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)

        onDrawBorderCircle(canvas)
    }

    private fun onDrawBorderCircle(canvas: Canvas?) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        paint.color = DEFAULT_BORDER_COLOR
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = DEFAULT_BORDER_WIDTH
        paint.strokeCap = Paint.Cap.BUTT
        canvas?.drawCircle(width/2f,height/2f,cornerRadius - DEFAULT_BORDER_WIDTH/2f,paint)
    }
}