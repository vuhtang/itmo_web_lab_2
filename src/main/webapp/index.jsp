<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Bubbles&display=swap" rel="stylesheet">
    <title>Lab 1</title>
</head>
<body>
<header>
    <div class="container">
        <div class="fio">
            <div class="fio-text">
                <span class="fio-text-before">Full name:</span>
                <span class="fio-text-after">Varyukhin Ivan</span>
            </div>
            <div class="fio-text">
                <span class="fio-text-before">Variant:</span>
                <span class="fio-text-after">639547</span>
            </div>
            <div class="fio-text">
                <span class="fio-text-before">Group:</span>
                <span class="fio-text-after">P32302</span>
            </div>
        </div>
    </div>
</header>
<div class="main">
    <div class="graph">
        <div class="container">
            <div class="graph-panel">
                <div class="panel-element">
                    <div id="image">
                        <canvas id="area-image" width="450" height="450"></canvas>
                    </div>
                </div>
                <div class="panel-element">
                    <form id="shot">
                        <div class="panel-element-inner">
                            <h4 id="r-label">R: <span id="r_visible">1</span></h4>
                            <input type="hidden" name="r" id="r_value" value="1">
                            <button type="button" class="r-buttons" value="1">
                                1
                            </button>
                            <button type="button" class="r-buttons" value="1.5">
                                1.5
                            </button>
                            <button type="button" class="r-buttons" value="2">
                                2
                            </button>
                            <button type="button" class="r-buttons" value="2.5">
                                2.5
                            </button>
                            <button type="button" class="r-buttons" id="r_3" value="3">
                                3
                            </button>
                        </div>
                        <div class="panel-element-inner">
                            <h4>X</h4>
                            <span id="x_warning" class="warning"></span>
                            <br>
                            <input id="x_-4" type="radio" name="x" value="-4">
                            <label for="x_-4">-4</label>

                            <input id="x_-3" type="radio" name="x" value="-3">
                            <label for="x_-3">-3</label>

                            <input id="x_-2" type="radio" name="x" value="-2">
                            <label for="x_-2">-2</label>

                            <input id="x_-1" type="radio" name="x" value="-1">
                            <label for="x_-1">-1</label>

                            <input id="x_0" type="radio" name="x" value="0">
                            <label for="x_0">0</label>

                            <input id="x_1" type="radio" name="x" value="1">
                            <label for="x_1">1</label>

                            <input id="x_2" type="radio" name="x" value="2">
                            <label for="x_2">2</label>

                            <input id="x_3" type="radio" name="x" value="3">
                            <label for="x_3">3</label>

                            <input id="x_4" type="radio" name="x" value="4">
                            <label for="x_4">4</label>
                        </div>
                        <div class="panel-element-inner">
                            <h4>Y</h4>
                            <span id="y_warning" class="warning"></span>
                            <br>
                            <input id="y" maxlength="6" type="text">
                        </div>
                        <div class="panel-element-inner">
                            <button id="fire" type="submit" form="shot">
                                FIRE
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="history">
        <div class="container">
            <div class="panel-element">
                <h2>History</h2>
            </div>
            <div class="panel-element">
                <table>
                    <thead>
                    <tr>
                        <th>R</th>
                        <th>X</th>
                        <th>Y</th>
                        <th>Result</th>
                        <th>Execution time</th>
                        <th>Current time</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <div class="panel-element">
                <form>
                    <button type="submit" id="clear">Clear history</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="module" src="src/index.js"></script>
</html>