import {consts} from "../resources/constants.js";
import {BASE_URL} from "../resources/routes.js";
import {jsonToHtmlTableRows} from "./json-to-html.js";
import {drawShotsFromJson} from "./visual/graphic.js";

export const api = {

    fetchShot: function (x, y, r, callback) {
        let table = consts.table
        let url = new URL(BASE_URL)
        url.searchParams.set('x', x)
        url.searchParams.set('y', y)
        url.searchParams.set('r', r)
        fetch(url, {
                method: 'GET',
                mode: 'no-cors'
            }
        ).then(resp => resp.text()
            .then(strResp => {
                table.insertAdjacentHTML('afterbegin', jsonToHtmlTableRows(strResp))
                if (callback) {
                    callback(x, y, strResp)
                }
            }))
            .catch(reason => console.log("error :(( " + reason))
    },

    requestShots: function () {
        let table = consts.table
        let url = new URL(BASE_URL)
        url.searchParams.set('req_shots', '1')
        fetch(url, {
                method: 'GET',
                mode: 'no-cors'
            }
        ).then(resp => resp.text()
            .then(strResp => {
                table.insertAdjacentHTML('afterbegin', jsonToHtmlTableRows(strResp))
                drawShotsFromJson(strResp)
            }))
            .catch(reason => console.log('error:(( ' + reason))
    },

    clearHistory: function () {
        let table = consts.table
        let url = new URL(BASE_URL)
        url.searchParams.set('clear', '1')
        fetch(url, {
                method: 'GET',
                mode: 'no-cors'
            }
        ).then(resp => resp.text()
            .then(() => table.innerHTML = ""))
            .catch(reason => console.log("error:(( " + reason))
    }
}