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

/* mượn sách */
function borrowBook(bookId) {
    // Gửi yêu cầu mượn sách đến servlet
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/Manage_Library/BorrowBookServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Xử lý phản hồi từ servlet
            alert(xhr.responseText); // Hiển thị thông báo
            location.reload(); // Tải lại trang để cập nhật thông tin
        }
    };
    xhr.send("book_id=" + bookId);
}