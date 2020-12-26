<?php

$url ='http://genbetadev.com';
$html = file_get_contents($url);

preg_match_all('/<a href="(.*?)"/',$html,$matches);
print_r($matches);
