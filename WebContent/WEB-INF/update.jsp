<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" flush="true" />
<body>

	<div class="container">
		<div class="row">

			<div class="alert alert-success" role="alert">
				<button type="button" data-dismiss="alert" class="close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="alert-heading">完了しました!</h4>
				<ul>
					<li>No.27のTodoを更新しました。</li>
				</ul>
			</div>

			<div class="alert alert-danger" role="alert">
				<button type="button" data-dismiss="alert" class="close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="alert-heading">エラーが発生しました！</h4>
				<ul>
					<li>題名は必須入力です。</li>
					<li>題名は100文字以内にしてください。</li>
					<li>期限は「YYYY/MM/DD」形式で入力してください。</li>
				</ul>
			</div>


			<form class="form-horizontal" action="#" method="post">

				更新フォーム
				<hr>
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">題名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" value="テストテスト"
							placeholder="題名">
					</div>
				</div>

				<div class="form-group">
					<label for="content" class="col-sm-2 control-label">詳細 </label>
					<div class="col-sm-10">
						<textarea class="form-control" id="content" placeholder="詳細">SQLの確認テストの採点と報告書を作成する。</textarea>

					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-2 control-label">重要度 </label>
					<div class="col-sm-10">
						<div class="radio">
							<label> <input type="radio" name="level" value="3"
								checked>★★★<br>
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="level" value="2">★★<br>
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="level" value="1">★
							</label>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="deadline" class="col-sm-2 control-label">期限</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="deadline"
							value="2015/06/15" placeholder="期限">
					</div>
				</div>

				<div class="row">
					<div class="col-sm-offset-2">
						<a href="index.html" class="btn btn-default"><span class=""
							aria-hidden="true">キャンセル</span></a> <a href="index.html"
							class="btn btn-primary"><span class="" aria-hidden="true">更新</span></a>
						<a href="index.html" class="btn btn-danger pull-right"><span
							class="" aria-hidden="true">削除</span></a>

					</div>
				</div>

			</form>
		</div>
	</div>
<jsp:include page="footer.jsp" flush="true" />
</body>
</html>