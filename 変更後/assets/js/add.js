
// 動きのきっかけとなるアニメーションの名前を定義
function fadeAnime() {

    //ふわっと動くきっかけのクラス名と動きのクラス名の設定
    $('.container').each(function () { //fadeInUpTriggerというクラス名が
        var elemPos = $(this).offset().top - 50; //要素より、50px上の
        var scroll = $(window).scrollTop();
        var windowHeight = $(window).height();
        if (scroll >= elemPos - windowHeight) {
            $(this).addClass('fadeUp');
            // 画面内に入ったらfadeInというクラス名を追記
        }
    });
    $('.inner').each(function () { //fadeInUpTriggerというクラス名が
        var elemPos = $(this).offset().top - 50; //要素より、50px上の
        var scroll = $(window).scrollTop();
        var windowHeight = $(window).height();
        if (scroll >= elemPos - windowHeight) {
            $(this).addClass('fadeUp');
            // 画面内に入ったらfadeInというクラス名を追記
        }
    });
    $('.news-all').each(function () { //fadeInUpTriggerというクラス名が
        var elemPos = $(this).offset().top - 50; //要素より、50px上の
        var scroll = $(window).scrollTop();
        var windowHeight = $(window).height();
        if (scroll >= elemPos - windowHeight) {
            $(this).addClass('fadeUp');
            // 画面内に入ったらfadeInというクラス名を追記
        }
    });


}//ここまでふわっと動くきっかけのクラス名と動きのクラス名の設定

// 画面をスクロールをしたら動く場合の記述
$(window).scroll(function () {

    fadeAnime();/* アニメーション用の関数を呼ぶ*/

});// ここまで画面をスクロールをしたら動く場合の記述

// 画面が読み込まれたらすぐに動く場合の記述
$(window).on('load', function () {

    fadeAnime();/* アニメーション用の関数を呼ぶ*/

});// ここまで画面が読み込まれたらすぐに動く場合の記述

function slideAnime() {
    //====左に動くアニメーションここから===
    $('.leftAnime').each(function () {
        var elemPos = $(this).offset().top - 50;
        var scroll = $(window).scrollTop();
        var windowHeight = $(window).height();
        if (scroll >= elemPos - windowHeight) {
            //左から右へ表示するクラスを付与
            //テキスト要素を挟む親要素（左側）とテキスト要素を元位置でアニメーションをおこなう
            $(this).addClass("slideAnimeLeftRight"); //要素を左枠外にへ移動しCSSアニメーションで左から元の位置に移動
            $(this).children(".leftAnimeInner").addClass("slideAnimeRightLeft");  //子要素は親要素のアニメーションに影響されないように逆の指定をし元の位置をキープするアニメーションをおこなう
        } else {
            //左から右へ表示するクラスを取り除く
            $(this).removeClass("slideAnimeLeftRight");
            $(this).children(".leftAnimeInner").removeClass("slideAnimeRightLeft");

        }
    });

}


// 画面が読み込まれたらすぐに動かしたい場合の記述
$(window).on('load', function () {
    slideAnime();/* アニメーション用の関数を呼ぶ*/
});// ここまで画面が読み込まれたらすぐに動かしたい場合の記述

