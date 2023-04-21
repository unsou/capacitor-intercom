<h2 align="center">Capacitor Intercom plugin</h2>
<p align="center"><strong><code>@foodello/intercom</code></strong></p>
<p align="center">
  Capacitor plugin for enabling Intercom capabilities based on the Capacitor community plugin
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2023?style=flat-square" />
  <a href="https://www.npmjs.com/package/@foodello/intercom"><img src="https://img.shields.io/npm/l/@foodello/intercom?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@foodello/intercom"><img src="https://img.shields.io/npm/dw/@foodello/intercom?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@foodello/intercom"><img src="https://img.shields.io/npm/v/@foodello/intercom?style=flat-square" /></a>
  <!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a href="#contributors"><img src="https://img.shields.io/badge/all%20contributors-14-orange?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->
</p>

## Notice 🚀

Thanks for the all the authors with their work in [`@capacitor-community/intercom`](https://github.com/capacitor-community/intercom
). We have noticed that the repository was left behind the newest updates and the original repository did not get updates quick enough once pull request were opened. So we decided to serve the newest Intercom capabilities under seperate org until the original repository catches the changes.

**This plugin is built for the Capacitor v4 upwards.**

## Installation

Using npm:

```bash
npm install @foodello/intercom
```

Using yarn:

```bash
yarn add @foodello/intercom
```

Sync native files:

```bash
npx cap sync
```

## API
<docgen-index>

* [`registerIdentifiedUser(...)`](#registeridentifieduser)
* [`loginIdentifiedUser(...)`](#loginidentifieduser)
* [`registerUnidentifiedUser()`](#registerunidentifieduser)
* [`loginUnidentifiedUser()`](#loginunidentifieduser)
* [`updateUser(...)`](#updateuser)
* [`logout()`](#logout)
* [`logEvent(...)`](#logevent)
* [`displayMessenger()`](#displaymessenger)
* [`displayMessageComposer(...)`](#displaymessagecomposer)
* [`displayHelpCenter()`](#displayhelpcenter)
* [`hideMessenger()`](#hidemessenger)
* [`displayLauncher()`](#displaylauncher)
* [`hideLauncher()`](#hidelauncher)
* [`displayInAppMessages()`](#displayinappmessages)
* [`hideInAppMessages()`](#hideinappmessages)
* [`displayCarousel(...)`](#displaycarousel)
* [`setUserHash(...)`](#setuserhash)
* [`setBottomPadding(...)`](#setbottompadding)
* [`sendPushTokenToIntercom(...)`](#sendpushtokentointercom)
* [`receivePush(...)`](#receivepush)
* [`displayArticle(...)`](#displayarticle)
* [`presentContent(...)`](#presentcontent)
* [`present(...)`](#present)
* [`setupUnreadConversationListener()`](#setupunreadconversationlistener)
* [`removeUnreadConversationListener()`](#removeunreadconversationlistener)
* [`getUnreadConversationCount()`](#getunreadconversationcount)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

## Usage

Import intercom plugin into your project.

```js
import { Intercom } from '@foodello/intercom';
import { PushNotifications } from '@capacitor/push-notifications';
````

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

IntercomPlugin Interface

### registerIdentifiedUser(...)

```typescript
registerIdentifiedUser(options: { userId?: string; email?: string; }) => any
```

| Param         | Type                                              |
| ------------- | ------------------------------------------------- |
| **`options`** | <code>{ userId?: string; email?: string; }</code> |

**Returns:** <code>any</code>

--------------------


### loginIdentifiedUser(...)

```typescript
loginIdentifiedUser(options: { userId?: string; email?: string; }) => any
```

Login an identified user with Intercom.

| Param         | Type                                              |
| ------------- | ------------------------------------------------- |
| **`options`** | <code>{ userId?: string; email?: string; }</code> |

**Returns:** <code>any</code>

--------------------


### registerUnidentifiedUser()

```typescript
registerUnidentifiedUser() => any
```

**Returns:** <code>any</code>

--------------------


### loginUnidentifiedUser()

```typescript
loginUnidentifiedUser() => any
```

Login an unidentified user with Intercom.

**Returns:** <code>any</code>

--------------------


### updateUser(...)

```typescript
updateUser(options: IntercomUserUpdateOptions) => any
```

Updates a user's attributes in Intercom.

| Param         | Type                                                                            |
| ------------- | ------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#intercomuserupdateoptions">IntercomUserUpdateOptions</a></code> |

**Returns:** <code>any</code>

--------------------


### logout()

```typescript
logout() => any
```

Logs the user out of Intercom.

**Returns:** <code>any</code>

--------------------


### logEvent(...)

```typescript
logEvent(options: { name: string; data?: any; }) => any
```

Logs an event with optional metadata in Intercom.

| Param         | Type                                       |
| ------------- | ------------------------------------------ |
| **`options`** | <code>{ name: string; data?: any; }</code> |

**Returns:** <code>any</code>

--------------------


### displayMessenger()

```typescript
displayMessenger() => any
```

**Returns:** <code>any</code>

--------------------


### displayMessageComposer(...)

```typescript
displayMessageComposer(options: { message: string; }) => any
```

Displays the Intercom Message Composer with an initial message.

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ message: string; }</code> |

**Returns:** <code>any</code>

--------------------


### displayHelpCenter()

```typescript
displayHelpCenter() => any
```

**Returns:** <code>any</code>

--------------------


### hideMessenger()

```typescript
hideMessenger() => any
```

Hides the Intercom Messenger.

**Returns:** <code>any</code>

--------------------


### displayLauncher()

```typescript
displayLauncher() => any
```

Displays the Intercom Launcher.

**Returns:** <code>any</code>

--------------------


### hideLauncher()

```typescript
hideLauncher() => any
```

Hides the Intercom Launcher.

**Returns:** <code>any</code>

--------------------


### displayInAppMessages()

```typescript
displayInAppMessages() => any
```

Displays Intercom In-App Messages.

**Returns:** <code>any</code>

--------------------


### hideInAppMessages()

```typescript
hideInAppMessages() => any
```

Hides Intercom In-App Messages.

**Returns:** <code>any</code>

--------------------


### displayCarousel(...)

```typescript
displayCarousel(options: { carouselId: string; }) => any
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ carouselId: string; }</code> |

**Returns:** <code>any</code>

--------------------


### setUserHash(...)

```typescript
setUserHash(options: { hmac: string; }) => any
```

Sets the HMAC user hash for Intercom Identity Verification.

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ hmac: string; }</code> |

**Returns:** <code>any</code>

--------------------


### setBottomPadding(...)

```typescript
setBottomPadding(options: { value: string; }) => any
```

Sets the bottom padding for the Intercom Messenger.

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>any</code>

--------------------


### sendPushTokenToIntercom(...)

```typescript
sendPushTokenToIntercom(options: { value: string; }) => any
```

Sends a push token to Intercom.

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>any</code>

--------------------


### receivePush(...)

```typescript
receivePush(notification: IntercomPushNotificationData) => any
```

Processes a received Intercom push notification.

| Param              | Type                                                                                  |
| ------------------ | ------------------------------------------------------------------------------------- |
| **`notification`** | <code><a href="#intercompushnotificationdata">IntercomPushNotificationData</a></code> |

**Returns:** <code>any</code>

--------------------


### displayArticle(...)

```typescript
displayArticle(options: { articleId: string; }) => any
```

| Param         | Type                                |
| ------------- | ----------------------------------- |
| **`options`** | <code>{ articleId: string; }</code> |

**Returns:** <code>any</code>

--------------------


### presentContent(...)

```typescript
presentContent(options: { contentType: IntercomContent; contentId: string; }) => any
```

Presents an Intercom content item (Article, Carousel, or Survey) by its type and ID.

| Param         | Type                                                                                             |
| ------------- | ------------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ contentType: <a href="#intercomcontent">IntercomContent</a>; contentId: string; }</code> |

**Returns:** <code>any</code>

--------------------


### present(...)

```typescript
present(options: { space: IntercomSpace; }) => any
```

Presents the Intercom's Help Center, Messenger, or Home based on the selected space.

| Param         | Type                                                                |
| ------------- | ------------------------------------------------------------------- |
| **`options`** | <code>{ space: <a href="#intercomspace">IntercomSpace</a>; }</code> |

**Returns:** <code>any</code>

--------------------


### setupUnreadConversationListener()

```typescript
setupUnreadConversationListener() => any
```

Setup listener for unread conversation count updates.

**Returns:** <code>any</code>

--------------------


### removeUnreadConversationListener()

```typescript
removeUnreadConversationListener() => any
```

Remove listener for unread conversation count updates.

**Returns:** <code>any</code>

--------------------


### getUnreadConversationCount()

```typescript
getUnreadConversationCount() => any
```

Get current unread conversation count.

**Returns:** <code>any</code>

--------------------


### Interfaces


#### IntercomUserUpdateOptions

<a href="#intercomuserupdateoptions">IntercomUserUpdateOptions</a> Interface
Represents the options for updating a user's attributes in Intercom.

| Prop                   | Type                                 |
| ---------------------- | ------------------------------------ |
| **`userId`**           | <code>string</code>                  |
| **`email`**            | <code>string</code>                  |
| **`name`**             | <code>string</code>                  |
| **`phone`**            | <code>string</code>                  |
| **`languageOverride`** | <code>string</code>                  |
| **`customAttributes`** | <code>{ [key: string]: any; }</code> |


#### IntercomPushNotificationData

<a href="#intercompushnotificationdata">IntercomPushNotificationData</a> Interface
Represents the structure of a received Intercom push notification.

| Prop                            | Type                |
| ------------------------------- | ------------------- |
| **`conversation_id`**           | <code>string</code> |
| **`message`**                   | <code>string</code> |
| **`body`**                      | <code>string</code> |
| **`author_name`**               | <code>string</code> |
| **`image_url`**                 | <code>string</code> |
| **`app_name`**                  | <code>string</code> |
| **`receiver`**                  | <code>string</code> |
| **`conversation_part_type`**    | <code>string</code> |
| **`intercom_push_type`**        | <code>string</code> |
| **`uri`**                       | <code>string</code> |
| **`push_only_conversation_id`** | <code>string</code> |
| **`instance_id`**               | <code>string</code> |
| **`title`**                     | <code>string</code> |
| **`priority`**                  | <code>number</code> |


### Enums


#### IntercomContent

| Members        | Value                   |
| -------------- | ----------------------- |
| **`Article`**  | <code>'article'</code>  |
| **`Carousel`** | <code>'carousel'</code> |
| **`Survey`**   | <code>'survey'</code>   |


#### IntercomSpace

| Members          | Value                     |
| ---------------- | ------------------------- |
| **`Home`**       | <code>'home'</code>       |
| **`Messages`**   | <code>'messages'</code>   |
| **`HelpCenter`** | <code>'helpCenter'</code> |

</docgen-api>

## Configurations
### iOS setup

- `ionic start my-cap-app --capacitor`
- `cd my-cap-app`
- `npm install —-save @foodello/intercom`
- `mkdir www && touch www/index.html`
- `npx cap add ios`
- add intercom keys to capacitor's configuration file

```
{
 …
  "plugins": {
   "Intercom": {
      "iosApiKey": "ios_sdk-xxx",
      "iosAppId": "yyy"
    }
  }
…
}
```

- `npx cap open ios`
- sign your app at xcode (general tab)

> Tip: every time you change a native code you may need to clean up the cache (Product > Clean build folder) and then run the app again.

### Android setup

- `ionic start my-cap-app --capacitor`
- `cd my-cap-app`
- `npm install —-save @foodello/intercom`
- `mkdir www && touch www/index.html`
- `npx cap add android`
- add intercom keys to capacitor's configuration file

```
{
 …
  "plugins": {
   "Intercom": {
      "androidApiKey": "android_sdk-xxx",
      "androidAppId": "yyy"
    }
  }
…
}
```

- `npx cap open android`

Now you should be set to go. Try to run your client using `ionic cap run android --livereload`.

> Tip: every time you change a native code you may need to clean up the cache (Build > Clean Project | Build > Rebuild Project) and then run the app again.

## License

MIT

## Original repository's maintainers and sponsors

This repository is based on the wonderful work of the official `@capacitor-community/intercom` -plugin. Here we want to acknowledge the mastermind and sponsors behind that work.

### Sponsors

<table>
  <tr>
    <td align="center">
      <a href="https://intenseloop.com">
      <img src="https://static.intenseloop.com/assets/logo-512x512.png" width="40" />
      </a>
    </td>
    <td>
      <a href="https://intenseloop.com">
      Intenseloop
      </a>
    </td>
  </tr>
</table>

### Maintainers

| Maintainer   | GitHub                                  | Social                                    |
| ------------ | --------------------------------------- | ----------------------------------------- |
| Stewan Silva | [stewones](https://github.com/stewones) | [@stewones](https://twitter.com/stewones) |

## Future plans

We are planning on implementing the web usage of Intercom within this plugin as well. If you have any ideas what we should include, please open a new issue for it.

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://twitter.com/stewones"><img src="https://avatars1.githubusercontent.com/u/719763?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Stew</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=stewones" title="Code">💻</a> <a href="https://github.com/capacitor-community/intercom/commits?author=stewones" title="Documentation">📖</a></td>
    <td align="center"><a href="https://davidseek.com/"><img src="https://avatars2.githubusercontent.com/u/17073950?v=4?s=75" width="75px;" alt=""/><br /><sub><b>David Seek</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=davidseek" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/rnikitin"><img src="https://avatars3.githubusercontent.com/u/1829318?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Roman Nikitin</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=rnikitin" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/atomassoni"><img src="https://avatars1.githubusercontent.com/u/17362459?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Anne Tomassoni</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=atomassoni" title="Code">💻</a> <a href="https://github.com/capacitor-community/intercom/pulls?q=is%3Apr+reviewed-by%3Aatomassoni" title="Reviewed Pull Requests">👀</a></td>
    <td align="center"><a href="https://github.com/mmodzelewski"><img src="https://avatars2.githubusercontent.com/u/7762633?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Maciej Modzelewski</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=mmodzelewski" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/spaghettiguru"><img src="https://avatars.githubusercontent.com/u/5624009?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Oleg Yuzvik</b></sub></a><br /><a href="#maintenance-spaghettiguru" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://github.com/gcorreaalves"><img src="https://avatars.githubusercontent.com/u/983426?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Gustavo Corrêa Alves</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=gcorreaalves" title="Documentation">📖</a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Jealvia"><img src="https://avatars.githubusercontent.com/u/28424830?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Jealvia</b></sub></a><br /><a href="#maintenance-Jealvia" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://adamduren.com/"><img src="https://avatars.githubusercontent.com/u/581097?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Adam Duren</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=adamduren" title="Code">💻</a> <a href="#maintenance-adamduren" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://github.com/ramikhafagi96"><img src="https://avatars.githubusercontent.com/u/38646828?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Rami Khafagi</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=ramikhafagi96" title="Code">💻</a></td>
    <td align="center"><a href="https://rdlabo.jp/"><img src="https://avatars.githubusercontent.com/u/9690024?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Masahiko Sakakibara</b></sub></a><br /><a href="#maintenance-rdlabo" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://github.com/camdjn"><img src="https://avatars.githubusercontent.com/u/7116085?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Dejardin Camille</b></sub></a><br /><a href="https://github.com/capacitor-community/intercom/commits?author=camdjn" title="Code">💻</a></td>
    <td align="center"><a href="https://scr2em.github.io/portfolio/"><img src="https://avatars.githubusercontent.com/u/4671486?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Mohamed Abdelgwad</b></sub></a><br /><a href="#maintenance-scr2em" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://github.com/shark404"><img src="https://avatars.githubusercontent.com/u/4898049?v=4?s=75" width="75px;" alt=""/><br /><sub><b>Nathan</b></sub></a><br /><a href="#maintenance-shark404" title="Maintenance">🚧</a></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
