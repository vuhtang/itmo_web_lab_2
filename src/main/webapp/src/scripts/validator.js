import {DOMElements} from "../utils/const/DOMElements.js";
import {messages} from "../resources/messages.js";
import {api} from "./api-functions.js";

export function bindValidation() {

    DOMElements.coordinatesX.forEach(elem => {
        elem.addEventListener('change', function () {
            DOMElements.coordinateXWarning.textContent = ""
        })
    })

    DOMElements.coordinateY.addEventListener("input", function () {
        let inputValue = DOMElements.coordinateY.value;
        if (!isNumeric(inputValue) || inputValue < -3 || inputValue > 5) {
            DOMElements.coordinateYWarning.textContent = messages['y_warning']['en']
            DOMElements.coordinateY.yIsValid = false
        } else {
            DOMElements.coordinateYWarning.textContent = ""
            DOMElements.coordinateY.yIsValid = true
        }
    })

    DOMElements.form.addEventListener("submit", function (event) {
        event.preventDefault()
        let currXValue
        DOMElements.coordinatesX.forEach(function (obj) {
            if (obj.checked) {
                currXValue = obj.value
            }
        })
        if (!currXValue) {
            DOMElements.coordinateXWarning.textContent = messages['x_warning']['en']
            return
        }
        if (!DOMElements.coordinateY.yIsValid) {
            DOMElements.coordinateYWarning.textContent = messages['y_warning']['en']
            return
        }
        api.fetchShot(currXValue, DOMElements.coordinateY.value, DOMElements.currentRHidden.value)
    })

}

function isNumeric(value) {
    return !isNaN(value - parseFloat(value));
}