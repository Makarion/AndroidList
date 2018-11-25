1. Projekt został stworzony w ramach przedmiotu Programowanie aplikacji dekstop oraz na urządzenia mobilne.  2. Projekt został stworzony przy użyciu środowiska Android Studio  3. Podczas tworzenia wykorzystana została metoda obróbki zdjęć zaimplementowana w projekcie 

https://github.com/ArthurHub/Android-Image-Cropper

Korzystanie z aplikacji:
1.Dodawanie zdjęcia

a) Wybór zdjęcia przez kliknięcie na ikonę ImageView.
b) Wyrażenie zgody na dostęp aplikacji do zasobów galerii (obsługa Dangerous Permissions).
c) Dobranie odpowiedniego kadru oraz wybranie opcji CROP.

Resztę wartości należy wpisać ręcznie oraz wcisnąć przycisk "Dodaj wyjazd". Nowy obiekt Wyjazd zostaje wtedy zapisany w bazie SQLITE,
w tabeli TRIPS.

2. Obejrzenie listy wycieczek

Wyświetlenie danych pobranych z bazy, stworzenie listy oraz przedstawienie jej w postaci RecyclerView.

3. Obejrzenie konkretnego wyjazdu poprzez kliknięcie na wiersz zawierający informacje o danym wyjeździe. Informacje o obiekcie wyświetlą
się w nowym oknie.

4. Usuwanie obiektu przy wykorzystaniu klasy ItemTouchHelper oraz metody onSwiped (przesunięcie wiersza skutkuje jego usunięciem z listy
  oraz bazy).

