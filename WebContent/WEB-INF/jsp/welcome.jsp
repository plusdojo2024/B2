<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
<link rel="stylesheet" href="css/welcome.css">
</head>

<body>
  <header>
  	 <h1 class="title">FORESE</h1>
  	<ul class = "menu-group">
  	<li class = "menu-item"><a href="/B2/LoginServlet" class = "button">ログイン/新規登録</a></li>
  	</ul>
  </header>

  <main>
   <div class="image"><img src="/B2/img/photo-1503174971373-b1f69850bded.avif" alt="家写真">
   <p>ようこそ</p>

   </div>
   <div class = "all">
   <div>
      <div>
        <div>
          <h3>機能説明：</h3>
          <p>「FORESE」は共同生活をサポートするアプリです。</p>
          <p>主な機能として、家事分担機能、支出管理機能、在庫管理機能が使えます。</p>
        </div>
        <br>
        <div>
          <h3>家事分担機能：</h3>
          <p>参加メンバーの担当家事を週単位で自動割り当てします。</p>
        </div>
        <br>
        <div>
          <h3>支出管理機能：</h3>
          <p>参加メンバーの支出情報を登録すると、各メンバーに精算を促します。</p>
        </div>
        <br>
        <div>
          <h3>在庫管理機能：</h3>
          <p>消耗品や必需品の在庫商品をお知らせし、備品不足を未然に防ぎます。</p>
        </div>
      </div>
    </div>

    <div>
      <img src="家事分担機能っぽい写真を入れる"><!-- 左側に表示（右側、真ん中でもオーケー。他の機能の写真の場位置） -->
      <div>
        <div>
          <h3>家事分担機能</h3>
        </div>
        <br>
        <div>
          <h3>家事分担一覧</h3>
          <p>一週間の家事担当を確認することができます。</p>
        </div>
        <br>
        <div>
          <h3>家事登録</h3>
          <p>家事名・頻度・労力を設定することができます。</p>
        </div>
        <br>
        <div>
          <h3>家事分担振り分け</h3>
          <p>頻度・労力を考慮しながら一週間分の家事担当を振り分けます。</p>
        </div>
      </div>
    </div>

    <div>
      <img src="支出管理っぽい写真を入れる">
      <div>
        <div>
          <h3>支出管理</h3>
        </div>
        <br>
        <div>
          <h3>レシート登録</h3>
          <p>お家の家計簿代わりになれます。固定費か否かを設定できるチェックボックス付き。</p>
        </div>
        <br>
        <div>
          <h3>精算機能：</h3>
          <p>個別で精算するのが面倒くさいあなた！朗報です。まとめて精算ボタンを実装することで、メンバー全員に精算を要求することが可能になりました。これでお金のやり取りはクリーンですね。</p>
        </div>
        <br>
        <div>
          <h3>支出一覧</h3>
          <p>お家のお財布事情が一目瞭然！</p>
        </div>
	  </div>
	</div>

    <div>
      <img src="在庫管理機能っぽい写真を入れる">
      <div>
        <div>
          <h3>在庫管理機能</h3>
        </div>
        <br>
        <div>
          <h3>消耗品登録</h3>
          <p>生活に欠かせないアイテムを登録することができます。</p>
        </div>
        <br>
        <div>
          <h3>消耗品在庫一覧</h3>
          <p>ティッシュやトイレットペーパーは絶対に必要ですよね。なのにすぐなくなる！解決します。この機能を使えば「〇」「△」「×」の三段階で在庫状況をお知らせできます。これで花粉症の季節も準備ばっちり〇</p>
        </div>
      </div>
    </div>
    </div>
   </main>
<footer></footer>
</body>
</html>