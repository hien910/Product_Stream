
function clickDiv(clickedContainer, pageUrl) {
    console.log("gaga")


    const clickedId = clickedContainer.querySelector("p").textContent;
    console.log(clickedId)

    // Tạo đường dẫn mới dựa trên id và pageUrl
    const newUrl = pageUrl + '/product/' + clickedId;

    // Chuyển hướng người dùng đến trang mới
    window.location.href = newUrl;
}

document.addEventListener("click", clickDiv)