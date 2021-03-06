
# Firma: *Polskie Smaki* :fries: :fork_and_knife: :hamburger:

## Table of contents
* [Informacje ogólne](#Informacje-ogólne)
* [Ogólne postanowienia](#Ogólne-postanowienia)
* [Technologie](#Wykorzystane-technologie)
* [Funkcjonalność](#Funkcjonalność)
* [Wymagania opisane przez użytkownika](#Wymagania-opisane-przez-użytkownika)


# Informacje ogólne
Aplikacja bazodanowa tworzona w ramach kursu "Bazy danych i systemy informacyjne". Stworzona przez: [Michał Kalina](https://github.com/KalinaMichal) oraz [Igor Cichecki](https://github.com/regin123). Repozytorium jest kopią [oryginalnego](https://github.com/regin123/DBProject)

## Ogólne postanowienia
Aplikacja bazodanowa dla sieci fastfood'ów "Polskie Smaki", będącej wieloosobową korporacją zatrudniającą wielu ludzi, mającej wiele oddziałów. Każdy odział może mieć coś specjalnego w menu w ramach tzw. "oferty lokalnej". 

## Wymagania opisane przez użytkownika
* Obsługa wszystkich zatrudnionych pracowników
* Kazdy pracownik moze sie zalogowac oraz sprawdzic swoją pensję
* Lista usług i ich obsługa
* Zleceniodawca oraz administratorzy mają możliwość modyfikowania danych
* Obsługiwane trzy posiomy dostępu:
** pracownik
** kierownik działu
** właścicil firmy

## Funkcjonalność
Każdy użytkownik musi się zalogować

<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/1.png" alt="drawing" height=350px/> 

## Funkcjonalność pracownika
* Sprawdzenie swojej wypłaty/etatu
* Wgląd na dane na swój temat przechowywane w bazie
* Dane kontaktowe kierownika działu

<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/2.png" alt="drawing" height=350px/> 
<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/3.png" alt="drawing" height=350px/> 

## Funkcjonalność kierownika działu
* Zmiana pensji pracownika
* Bonusy świąteczne dla pracowników przy określonym budżecie (wykorzystano tranzajcję)
* Zatrudnienie\zwolnienie pracownika
* Dodanie\usunięcie\zmiana usług

<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/4.png" alt="drawing" height=350px/> 
<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/5.png" alt="drawing" height=350px/> 
<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/6.png" alt="drawing" height=350px/> 
<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/7.png" alt="drawing" height=350px/> 

## Właściciel
* Te same uprawnienia co kierownik działu
* Zmiana pensji kierownika
* Zwolnienie\zatrudnienie kierownika
* Obsługa backupu

<img src="https://github.com/KalinaMichal/Fast_food_PolskieSmaki/blob/master/queries%20i%20baza%20danych/obrazki/8.png" alt="drawing" height=350px/> 

### Wykorzystane technologie

<img src="https://gallery.dpcdn.pl/imgc/UGC/62325/g_-_-x-_-_-_x20151005064320_0.png" alt="drawing" height=50px/><img src="https://vignette.wikia.nocookie.net/jfx/images/5/5a/JavaFXIsland600x300.png/revision/latest?cb=20070917150551" alt="drawing" height=50px/><img 
src="https://i0.wp.com/gluonhq.com/wp-content/uploads/2015/02/SceneBuilderLogo.png?fit=781%2C781&ssl=1" alt="drawing" height=50px/><img 
src="https://www.techcentral.ie/wp-content/uploads/2019/07/Java_jdk_logo_web-372x210.jpg" alt="drawing" height=50px/><img 
src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/IntelliJ_IDEA_Logo.svg/1024px-IntelliJ_IDEA_Logo.svg.png" alt="drawing" height=50px/> 

