import listenUserChanges from "./listener.js";
import {requestShots} from "./api-functions.js";
import {processGraphicElements} from "./visual/graphic.js";

document.addEventListener("DOMContentLoaded", () => {
    startApplication()
})

const startApplication = () => {
    processGraphicElements()
    requestShots()
    listenUserChanges()
}
