// 削除 확인
$(function() {
     $('a.confirmDeletion').click(function(){
      if(!confirm('削除확인')) return false;});
});