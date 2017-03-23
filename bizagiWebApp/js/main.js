/**
 * File inputs controller
 */
(function () {
    var fileInput = document.getElementById("file");
    fileInput.addEventListener("change", function (e) {
        var inputValue = e.target.value;
        var fileName = (inputValue) ? e.target.value.split('\\').pop() : "Upload your CV";
        var fileTitleElement = document.getElementById("cv-label");

        fileTitleElement.innerHTML = fileName;
    });
})();

function getQueryString(url) {
    var params = {};
    url = url || window.location.href;
    var query = url.indexOf("?") > 0 ? url.substring(url.indexOf("?") + 1) : "";
    var pairs = query.split("&");
    for (var i = pairs.length - 1; i >= 0; i--) {
        var pos = pairs[i].indexOf('=');
        if (pos == -1)
            continue;
        var argname = pairs[i].substring(0, pos);
        var value = pairs[i].substring(pos + 1);
        params[argname] = unescape(value);
    }
    return params;
}

function checkStatus() {
    var qs = getQueryString();
    var message = "";
    var buttonDisplay = "";
    var mainSection = document.getElementsByClassName("main-section");
    var responseSection = document.getElementsByClassName("response-section");
    var titleEml = responseSection[0].querySelector("h1");
    var linkElm = responseSection[0].querySelector("a");

    if (qs.status == 200) {
        mainSection[0].style.display = "none";
        responseSection[0].style.visibility = "visible";
        message = "Thank you, your data has been saved!";
        buttonDisplay = "Come Back!";
        titleEml.innerHTML = message;
        linkElm.innerText = buttonDisplay;
        linkElm.href = "index.html";
    } else if (qs.status == 500) {
        mainSection[0].style.display = "none";
        responseSection[0].style.visibility = "visible";
        message = qs.message || "Something went wrong, please check your information and try again";
        buttonDisplay = "Verify my information";
        titleEml.innerHTML = message;
        linkElm.innerText = buttonDisplay;
        linkElm.href = "javascript:window.history.back()";
    }
}