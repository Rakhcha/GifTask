# GifTask

## Описание

Создать сервис, который обращается к сервису курсов валют, и отображает gif:
 - Курс по отношению к USD за сегодня стал выше вчерашнего, отдаем рандомную [отсюда](https://giphy.com/search/rich)
 - В противном случае - [отсюда](https://giphy.com/search/broke)

## Ссылки

- REST API курсов валют - [docs.openexchangerates.org](https://docs.openexchangerates.org/)
- REST API гифок - [developers.giphy.com](https://developers.giphy.com/docs/api#quick-start-guide)

## Stack

- Java 17
- Lombok
- Spring Boot 2
- Spring Cloud OpenFeign

## Процесс запуска

- Клонируем репозиторий с помощью: `git clone https://github.com/Rakhcha/GifTask.git`
- Переходим в папку с проектом и собираем пакет с помощью: `gradle build`
- После сборки переходим в build\libs и запускаем проект с помощью: `java -jar AlphaTask-0.0.1-SNAPSHOT.jar`

## Эндпоинт

`/api/v1/statusGif?rateCode=###`, где ### - код валюты, например EUR **(По умолчанию RUB).**

Возвращает json response в виде:

```json
{
    "data": {
        "id": "URurVpL1pjb7ngf9Z8",
        "url": "https://giphy.com/gifs/NamasteCar-range-rover-autobiography-svautobiography-URurVpL1pjb7ngf9Z8",
        "embed_url": "https://giphy.com/embed/URurVpL1pjb7ngf9Z8"
    },
    "meta": {
        "msg": "OK",
        "status": "200",
        "response_id": "746cf73683196ce5423c318560101e11c5a8b0d8"
    }
}
```
