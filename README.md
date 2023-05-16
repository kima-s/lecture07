# 概要

HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを
実装。

- http://localhost:8080/names?name=koyama のようにクエリ文字列を受け取れるようにした。
- 名前以外にも生年月日を受け取れるよう実装した。
- バリデーションについて調べてnameが空文字、null、20文字以上の場合はエラーとした。