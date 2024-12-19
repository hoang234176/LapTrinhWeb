/**
 * 
 */

function validateForm() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    // Kiểm tra độ dài mật khẩu
    if (password.length < 8) {
        alert("Mật khẩu phải có ít nhất 8 ký tự!");
        return false;
    }

    // Kiểm tra mật khẩu xác nhận có trùng với mật khẩu không
    if (password !== confirmPassword) {
        alert("Mật khẩu xác nhận không khớp!");
        return false;
    }

    return true; // Nếu tất cả điều kiện đều hợp lệ, form sẽ được gửi đi
}
