package com.johnkenedy.cryptotracker.crypto.presentation.coin_detail

import androidx.compose.ui.graphics.Path

//If we need someday hehe
fun Path.drawSmoothPath(drawPoints: List<DataPoint>) {
    if (drawPoints.size < 2) return

    this.moveTo(drawPoints.first().x, drawPoints.first().y)

    for (i in 0 until drawPoints.size - 1) {
        val p0 = drawPoints.getOrNull(i - 1) ?: drawPoints[i]
        val p1 = drawPoints[i]
        val p2 = drawPoints[i + 1]
        val p3 = drawPoints.getOrNull(i + 2) ?: p2

        // The "smoothness" factor (0.2f is usually a good sweet spot)
        val smoothness = 0.2f

        // Calculate control point 1 (relative to p1)
        val cp1x = p1.x + (p2.x - p0.x) * smoothness
        val cp1y = p1.y + (p2.y - p0.y) * smoothness

        // Calculate control point 2 (relative to p2)
        val cp2x = p2.x - (p3.x - p1.x) * smoothness
        val cp2y = p2.y - (p3.y - p1.y) * smoothness

        this.cubicTo(
            x1 = cp1x, y1 = cp1y,
            x2 = cp2x, y2 = cp2y,
            x3 = p2.x, y3 = p2.y
        )
    }
}

//val linePath = Path().apply {
//    drawSmoothPath(drawPoints)
//}