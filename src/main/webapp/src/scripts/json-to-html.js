export function jsonToHtmlTableRows(json) {
    let shots = JSON.parse(json)['shots']
    let tableRows = "";
    for (let i = 0; i < shots.length; i++) {
        tableRows += `<tr>
                        <td>${shots[i]['r']}</td>
                        <td>${shots[i]['x']}</td>
                        <td>${shots[i]['y']}</td>
                        <td>${shots[i]['result']}</td>
                        <td>${shots[i]['currTime']}</td>
                        <td>${shots[i]['execTime']}</td>
                        </tr>`
    }
    return tableRows
}