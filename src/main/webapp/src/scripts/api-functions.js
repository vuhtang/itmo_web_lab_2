import {consts} from "../resources/constants.js";
import {BASE_URL} from "../resources/routes.js";

const api = {

    fetchShot: function (x, y, r) {
        let table = consts.table
        let url = new URL(BASE_URL)
        url.searchParams.set('x', x)
        url.searchParams.set('y', y)
        url.searchParams.set('r', r)
        fetch(url, {
                method: 'GET',
                mode: 'no-cors'
            }
        ).then(res => res.text()
            .then(strRes => table.insertAdjacentHTML('afterbegin', strRes)))
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
        ).then(res => res.text()
            .then(strRes => table.insertAdjacentHTML('afterbegin', strRes)))
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
        ).then(res => res.text()
            .then(() => table.innerHTML = ""))
            .catch(reason => console.log("error:(( " + reason))
    }
}

export const fetchShot = api.fetchShot
export const requestShots = api.requestShots
export const clearHistory = api.clearHistory