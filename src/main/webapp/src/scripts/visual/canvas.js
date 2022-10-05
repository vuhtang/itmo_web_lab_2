function drawOnCanvas() {

    const canvas = document.getElementById("area-image")
    if (canvas.getContext) {
        const ctx = canvas.getContext('2d')
        const indent = 6
        const height = canvas.height
        const width = canvas.width
        const centerX = width / 2
        const centerY = height / 2
        const R = width / 3
        ctx.lineWidth = 2
        ctx.lineJoin = 'round'

        function drawAxes() {
            ctx.beginPath()
            let arrowWidth = 5
            let arrowLength = 10

            //x
            ctx.moveTo(indent, height / 2)
            ctx.lineTo(width - indent, height / 2)
            ctx.lineTo(width - indent - arrowLength, height / 2 - arrowWidth)
            ctx.moveTo(width - indent, height / 2)
            ctx.lineTo(width - indent - arrowLength, height / 2 + arrowWidth)

            //y
            ctx.moveTo(width / 2, height - indent)
            ctx.lineTo(width / 2, indent)
            ctx.lineTo(width / 2 + arrowWidth, indent + arrowLength)
            ctx.moveTo(width / 2, indent)
            ctx.lineTo(width / 2 - arrowWidth, indent + arrowLength)

            ctx.stroke()
        }

        function drawMarks() {
            let markLength = 3

            ctx.beginPath()

            //x
            ctx.moveTo(centerX + R / 2, centerY - 2 * markLength)
            ctx.lineTo(centerX + R / 2, centerY + 2 * markLength)
            ctx.moveTo(centerX + R, centerY - 2 * markLength)
            ctx.lineTo(centerX + R, centerY + 2 * markLength)
            ctx.moveTo(centerX - R / 2, centerY - 2 * markLength)
            ctx.lineTo(centerX - R / 2, centerY + 2 * markLength)
            ctx.moveTo(centerX - R, centerY - 2 * markLength)
            ctx.lineTo(centerX - R, centerY + 2 * markLength)

            //y
            ctx.moveTo(centerX - 2 * markLength, centerY - R / 2)
            ctx.lineTo(centerX + 2 * markLength, centerY - R / 2)
            ctx.moveTo(centerX - 2 * markLength, centerY - R)
            ctx.lineTo(centerX + 2 * markLength, centerY - R)
            ctx.moveTo(centerX - 2 * markLength, centerY + R / 2)
            ctx.lineTo(centerX + 2 * markLength, centerY + R / 2)
            ctx.moveTo(centerX - 2 * markLength, centerY + R)
            ctx.lineTo(centerX + 2 * markLength, centerY + R)

            ctx.stroke()
        }

        function drawText() {
            const fontSize = 17
            ctx.fillStyle = '#000000'
            ctx.font = `${fontSize}px sans-serif`
            const textR2 = ctx.measureText('R/2')
            const textR = ctx.measureText('R')

            //x
            ctx.fillText('R/2', centerX + R / 2 - textR2.width / 2, centerY + 22)
            ctx.fillText('R', centerX + R - textR.width / 2, centerY + 22)
            ctx.fillText('R/2', centerX - R / 2 - textR2.width / 2, centerY + 22)
            ctx.fillText('R', centerX - R - textR.width / 2, centerY + 22)

            //y
            ctx.fillText('R/2', centerX + 12, centerY + R / 2 + fontSize / 2)
            ctx.fillText('R', centerX + 12, centerY + R + fontSize / 2)
            ctx.fillText('R/2', centerX + 12, centerY - R / 2 + fontSize / 2)
            ctx.fillText('R', centerX + 12, centerY - R + fontSize / 2)
        }

        function drawFigures() {
            ctx.fillStyle = 'rgba(255,116,0,0.41)'
            ctx.beginPath()
            ctx.moveTo(centerX, centerY)
            ctx.lineTo(centerX, centerY - R)
            ctx.lineTo(centerX + R/2, centerY - R)
            ctx.lineTo(centerX + R/2, centerY)
            ctx.fill()

            ctx.beginPath()
            ctx.moveTo(centerX, centerY)
            ctx.lineTo(centerX - R, centerY)
            ctx.lineTo(centerX, centerY + R)
            ctx.fill()

            ctx.beginPath()
            ctx.moveTo(centerX, centerY)
            ctx.arc(centerX, centerY, R, 0, Math.PI / 2)
            ctx.fill()


        }

        drawAxes()
        drawMarks()
        drawFigures()
        drawText()
    }
}

export default drawOnCanvas;