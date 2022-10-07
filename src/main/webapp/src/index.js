import {listenUserChanges} from "./scripts/listener.js";
import {api} from "./scripts/api-functions.js";
import {processGraphicElements} from "./scripts/visual/graphic.js";

document.addEventListener("DOMContentLoaded", () => {
    startApplication()
})

const startApplication = () => {
    processGraphicElements()
    listenUserChanges()
    api.requestShots()
}
