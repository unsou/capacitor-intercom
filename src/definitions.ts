/**
 * IntercomPlugin Interface
 */
export interface IntercomPlugin {
  /**
   * @deprecated
   * This method is deprecated. Use `loginIdentifiedUser()` instead.
   *
   * Registers an identified user with Intercom.
   */
  registerIdentifiedUser(options: {
    userId?: string;
    email?: string;
  }): Promise<void>;

  /**
   * Login an identified user with Intercom.
   */
  loginIdentifiedUser(options: {
    userId?: string;
    email?: string;
  }): Promise<void>;

  /**
   * @deprecated
   * This method is deprecated. Use `loginUnidentifiedUser()` instead.
   *
   * Registers an unidentified user with Intercom.
   */
  registerUnidentifiedUser(): Promise<void>;

  /**
   * Login an unidentified user with Intercom.
   */
  loginUnidentifiedUser(): Promise<void>;

  /**
   * Updates a user's attributes in Intercom.
   */
  updateUser(options: IntercomUserUpdateOptions): Promise<void>;

  /**
   * Logs the user out of Intercom.
   */
  logout(): Promise<void>;

  /**
   * Logs an event with optional metadata in Intercom.
   */
  logEvent(options: { name: string; data?: any }): Promise<void>;

  /**
   * @deprecated
   * This method is deprecated, use `present()` instead.
   *
   * Displays the Intercom Messenger.
   */
  displayMessenger(): Promise<void>;

  /**
   * Displays the Intercom Message Composer with an initial message.
   */
  displayMessageComposer(options: { message: string }): Promise<void>;

  /**
   * @deprecated
   * This method is deprecated, use `present()` instead.
   *
   * Displays the Intercom Help Center.
   */
  displayHelpCenter(): Promise<void>;

  /**
   * Hides the Intercom Messenger.
   */
  hideMessenger(): Promise<void>;

  /**
   * Displays the Intercom Launcher.
   */
  displayLauncher(): Promise<void>;

  /**
   * Hides the Intercom Launcher.
   */
  hideLauncher(): Promise<void>;

  /**
   * Displays Intercom In-App Messages.
   */
  displayInAppMessages(): Promise<void>;

  /**
   * Hides Intercom In-App Messages.
   */
  hideInAppMessages(): Promise<void>;

  /**
   * @deprecated
   * This method is deprecated, use `presentContent()` instead.
   *
   * Displays an Intercom Carousel by its ID.
   */
  displayCarousel(options: { carouselId: string }): Promise<void>;

  /**
   * Sets the HMAC user hash for Intercom Identity Verification.
   */
  setUserHash(options: { hmac: string }): Promise<void>;

  /**
   * Sets the bottom padding for the Intercom Messenger.
   */
  setBottomPadding(options: { value: string }): Promise<void>;

  /**
   * Sends a push token to Intercom.
   */
  sendPushTokenToIntercom(options: { value: string }): Promise<void>;

  /**
   * Processes a received Intercom push notification.
   */
  receivePush(notification: IntercomPushNotificationData): Promise<void>;

  /**
   * @deprecated
   * This method is deprecated, use `presentContent()` instead.
   *
   * Displays an Intercom Article by its ID.
   */
  displayArticle(options: { articleId: string }): Promise<void>;

  /**
   * Presents an Intercom content item (Article, Carousel, or Survey) by its type and ID.
   */
  presentContent(options: {
    contentType: IntercomContent;
    contentId: string;
  }): Promise<void>;

  /**
   * Presents the Intercom's Help Center, Messenger, or Home based on the selected space.
   */
  present(options: { space: IntercomSpace }): Promise<void>;

  /**
   * Setup listener for unread conversation count updates.
   */
  setupUnreadConversationListener(): Promise<void>;

  /**
   * Remove listener for unread conversation count updates.
   */
  removeUnreadConversationListener(): Promise<void>;

  /**
   * Get current unread conversation count.
   */
  getUnreadConversationCount(): Promise<{ unreadCount: number }>;
}

/**
 * IntercomPushNotificationData Interface
 * Represents the structure of a received Intercom push notification.
 */
export interface IntercomPushNotificationData {
  conversation_id: string;
  message: string;
  body: string;
  author_name: string;
  image_url: string;
  app_name: string;
  receiver: string;
  conversation_part_type: string;
  intercom_push_type: string;
  uri: string;
  push_only_conversation_id: string;
  instance_id: string;
  title: string;
  priority: number;
}

/**
 * IntercomUserUpdateOptions Interface
 * Represents the options for updating a user's attributes in Intercom.
 */
export interface IntercomUserUpdateOptions {
  userId?: string;
  email?: string;
  name?: string;
  phone?: string;
  languageOverride?: string;
  customAttributes?: { [key: string]: any };
}

/**
 * IntercomSpace Enum
 * Represents the different spaces available for presentation within the Intercom Messenger.
 */
export enum IntercomSpace {
  Home = 'home',
  Messages = 'messages',
  HelpCenter = 'helpCenter',
}

/**
 * IntercomContent Enum
 * Represents the different content types that can be presented within the Intercom Messenger.
 */
export enum IntercomContent {
  Article = 'article',
  Carousel = 'carousel',
  Survey = 'survey',
}
