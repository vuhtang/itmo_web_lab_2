import {DOMElements} from "../utils/const/DOMElements.js";
import {api} from "./api-functions.js";
import {drawOnCanvas, clearCanvas} from "./visual/canvas.js"

export function listenButtons() {

    let buttons = DOMElements.buttonsRVisible
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', function () {
            DOMElements.currentRHidden.value = buttons[i].value
            DOMElements.currentRVisible.textContent = buttons[i].value
        })
    }

    DOMElements.clearButton.addEventListener('click', function (event) {
        event.preventDefault()
        api.clearHistory()
        clearCanvas()
        drawOnCanvas()
    })

}