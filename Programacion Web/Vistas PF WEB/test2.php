<?php
require 'simple_html_dom.php';
$url = 'http://genbetadev.com';
$html = file_get_html( $url );
$posts = $html->find('div[class=post]');
foreach( $posts as $post ){
	$link = $post->find('h2 a',0);
	$url = $link->attr['href'];
	$title = $link->innertext;
	$img = $post->find('div[class=post-body] img',0)->attr['src'];
	echo $title,"\n",$url,"\n",$img,"\n\n";
}
