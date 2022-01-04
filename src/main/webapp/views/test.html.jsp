<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<form action="/test" method="post">
Enter Username:<input type="text" name="username" id="id_username"><br>
Enter Password:<input type="password" name="password" id="id_password"><br>
<button type="submit" class="button app-login-button" id="id_submit"><i class="fas fa-sign-in-alt"></i> Login</button>
<script src="/js/security.js"></script>
<script>
const inputContainers = document.querySelectorAll(".app-input");

inputContainers.forEach((container) => {
    const input = container.querySelector("input");
    const events = ["focus", "blur"];

    events.forEach((event) => {
        input.addEventListener(event, () => {
            if (!input.value) {
                toggleClass(container, "input-active");
            }
        });
    });
});

function toggleClass(element, className) {
    const isActive = element.classList.contains(className);

    if (isActive) {
        element.classList.remove(className);
    } else {
        element.classList.add(className);
    }
}

$('.app-login-button').click(function() {
    $(this).attr('disabled', true);
    $(this).html('<i class="fas fa-spinner fa-spin"></i>');
    $(this).closest('form').submit();
});
</script>
</body>
</html>