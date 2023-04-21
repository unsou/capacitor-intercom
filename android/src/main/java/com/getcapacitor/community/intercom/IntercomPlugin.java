package com.getcapacitor.community.intercom;

import androidx.annotation.NonNull;

import com.getcapacitor.CapConfig;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.IntercomContent;
import io.intercom.android.sdk.IntercomError;
import io.intercom.android.sdk.IntercomSpace;
import io.intercom.android.sdk.IntercomStatusCallback;
import io.intercom.android.sdk.UnreadConversationCountListener;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.identity.Registration;
import io.intercom.android.sdk.push.IntercomPushClient;

@CapacitorPlugin(name = "Intercom", permissions = @Permission(strings = {}, alias = "receive"))
public class IntercomPlugin extends Plugin implements UnreadConversationCountListener {
    private final IntercomPushClient intercomPushClient = new IntercomPushClient();

    @Override
    public void load() {
        // Set up Intercom
        setUpIntercom();

        // load parent
        super.load();
    }

    @Override
    public void handleOnStart() {
        super.handleOnStart();
        bridge.getActivity().runOnUiThread(() -> {
            //We also initialize intercom here just in case it has died. If Intercom is already set up, this won't do anything.
            setUpIntercom();
            Intercom.client().handlePushMessage();
        });
    }

    @PluginMethod
    @Deprecated
    public void registerIdentifiedUser(PluginCall call) {
        String email = call.getString("email");
        String userId = call.getData().getString("userId");

        Registration registration = new Registration();

        if (email != null && email.length() > 0) {
            registration = registration.withEmail(email);
        }
        if (userId != null && userId.length() > 0) {
            registration = registration.withUserId(userId);
        }
        Intercom.client().loginIdentifiedUser(registration, new IntercomStatusCallback() {
            @Override
            public void onSuccess() {
                call.resolve();
            }

            @Override
            public void onFailure(@NonNull IntercomError intercomError) {
                call.reject("Error logging in: " + intercomError.getErrorMessage());
            }
        });
    }

    @PluginMethod
    public void loginIdentifiedUser(PluginCall call) {
        String email = call.getString("email");
        String userId = call.getData().getString("userId");

        Registration registration = new Registration();

        if (email != null && email.length() > 0) {
            registration = registration.withEmail(email);
        }
        if (userId != null && userId.length() > 0) {
            registration = registration.withUserId(userId);
        }
        Intercom.client().loginIdentifiedUser(registration, new IntercomStatusCallback() {
            @Override
            public void onSuccess() {
                call.resolve();
            }

            @Override
            public void onFailure(@NonNull IntercomError intercomError) {
                call.reject("Error logging in: " + intercomError.getErrorMessage());
            }
        });
    }

    @PluginMethod
    @Deprecated
    public void registerUnidentifiedUser(PluginCall call) {
        Intercom.client().loginUnidentifiedUser(new IntercomStatusCallback() {
            @Override
            public void onSuccess() {
                call.resolve();
            }

            @Override
            public void onFailure(@NonNull IntercomError intercomError) {
                call.reject("Error logging in unidentified user: " + intercomError.getErrorMessage());
            }
        });
    }

    @PluginMethod
    public void loginUnidentifiedUser(PluginCall call) {
        Intercom.client().loginUnidentifiedUser(new IntercomStatusCallback() {
            @Override
            public void onSuccess() {
                call.resolve();
            }

            @Override
            public void onFailure(@NonNull IntercomError intercomError) {
                call.reject("Error logging in unidentified user: " + intercomError.getErrorMessage());
            }
        });
    }

    @PluginMethod
    public void updateUser(PluginCall call) {
        UserAttributes.Builder builder = new UserAttributes.Builder();
        String userId = call.getString("userId");
        if (userId != null && userId.length() > 0) {
            builder.withUserId(userId);
        }
        String email = call.getString("email");
        if (email != null && email.length() > 0) {
            builder.withEmail(email);
        }
        String name = call.getString("name");
        if (name != null && name.length() > 0) {
            builder.withName(name);
        }
        String phone = call.getString("phone");
        if (phone != null && phone.length() > 0) {
            builder.withPhone(phone);
        }
        String languageOverride = call.getString("languageOverride");
        if (languageOverride != null && languageOverride.length() > 0) {
            builder.withLanguageOverride(languageOverride);
        }
        Map<String, Object> customAttributes = mapFromJSON(call.getObject("customAttributes"));
        if (customAttributes != null) {
            builder.withCustomAttributes(customAttributes);
        }
        Intercom.client().updateUser(builder.build(), new IntercomStatusCallback() {
            @Override
            public void onSuccess() {
                call.resolve();
            }

            @Override
            public void onFailure(@NonNull IntercomError intercomError) {
                call.reject("Error updating user: " + intercomError.getErrorMessage());
            }
        });
    }

    @PluginMethod
    public void logout(PluginCall call) {
        Intercom.client().logout();
        call.resolve();
    }

    @PluginMethod
    public void logEvent(PluginCall call) {
        String eventName = call.getString("name", "");
        if (eventName == null || eventName.isEmpty()) {
            call.reject("Event name is missing or empty");
            return;
        }

        Map<String, Object> metaData = mapFromJSON(call.getObject("data"));
        if (metaData == null) {
            Intercom.client().logEvent(eventName);
        } else {
            Intercom.client().logEvent(eventName, metaData);
        }

        call.resolve();
    }

    @PluginMethod
    public void present(PluginCall call) {
        Map<String, IntercomSpace> spaceMapping = new HashMap<>();
        spaceMapping.put("helpCenter", IntercomSpace.HelpCenter);
        spaceMapping.put("messages", IntercomSpace.Messages);
        spaceMapping.put("home", IntercomSpace.Home);

        String spaceString = call.getString("space", "");
        IntercomSpace space = spaceMapping.get(spaceString);
        if (space == null) {
            space = IntercomSpace.Home;
        }

        Intercom.client().present(space);
        call.resolve();
    }


    @PluginMethod
    @Deprecated
    public void displayMessenger(PluginCall call) {
        Intercom.client().present();
        call.resolve();
    }

    @PluginMethod
    public void displayMessageComposer(PluginCall call) {
        String message = call.getString("message");
        Intercom.client().displayMessageComposer(message);
        call.resolve();
    }

    @PluginMethod
    @Deprecated
    public void displayHelpCenter(PluginCall call) {
        Intercom.client().present(IntercomSpace.HelpCenter);
        call.resolve();
    }

    @PluginMethod
    public void hideMessenger(PluginCall call) {
        Intercom.client().hideIntercom();
        call.resolve();
    }

    @PluginMethod
    public void displayLauncher(PluginCall call) {
        Intercom.client().setLauncherVisibility(Intercom.VISIBLE);
        call.resolve();
    }

    @PluginMethod
    public void hideLauncher(PluginCall call) {
        Intercom.client().setLauncherVisibility(Intercom.GONE);
        call.resolve();
    }

    @PluginMethod
    public void displayInAppMessages(PluginCall call) {
        Intercom.client().setInAppMessageVisibility(Intercom.VISIBLE);
        call.resolve();
    }

    @PluginMethod
    public void hideInAppMessages(PluginCall call) {
        Intercom.client().setLauncherVisibility(Intercom.GONE);
        call.resolve();
    }

    @PluginMethod
    public void presentContent(PluginCall call) {
        String contentId = call.getString("contentId");
        if (contentId == null || contentId.isEmpty()) {
            call.reject("contentId is missing or empty");
            return;
        }

        Map<String, IntercomContent> contentTypeMapping = new HashMap<>();
        contentTypeMapping.put("carousel", new IntercomContent.Carousel(contentId));
        contentTypeMapping.put("survey", new IntercomContent.Survey(contentId));
        contentTypeMapping.put("article", new IntercomContent.Article(contentId));

        String contentTypeString = call.getString("contentType", "");
        IntercomContent contentType = contentTypeMapping.get(contentTypeString);
        if (contentType == null) {
            call.reject("contentType not found");
            return;
        }

        Intercom.client().presentContent(contentType);
        call.resolve();
    }

    @PluginMethod
    @Deprecated
    public void displayCarousel(PluginCall call) {
        String carouselId = call.getString("carouselId");
        if (carouselId == null || carouselId.isEmpty()) {
            call.reject("carouselId is missing or empty");
            return;
        }
        Intercom.client().presentContent(new IntercomContent.Carousel(carouselId));
        call.resolve();
    }

    @PluginMethod
    @Deprecated
    public void displayArticle(PluginCall call) {
        String articleId = call.getString("articleId");
        if (articleId == null || articleId.isEmpty()) {
            call.reject("articleId is missing or empty");
            return;
        }
        Intercom.client().presentContent(new IntercomContent.Article(articleId));
        call.resolve();
    }

    @PluginMethod
    public void setUserHash(PluginCall call) {
        String hmac = call.getString("hmac");
        if (hmac == null || hmac.isEmpty()) {
            call.reject("hmac is missing or empty");
            return;
        }
        Intercom.client().setUserHash(hmac);
        call.resolve();
    }

    @PluginMethod
    public void setBottomPadding(PluginCall call) {
        String stringValue = call.getString("value");
        if (stringValue == null || stringValue.isEmpty()) {
            call.reject("value is missing or empty");
            return;
        }
        int value = Integer.parseInt(stringValue);
        Intercom.client().setBottomPadding(value);
        call.resolve();
    }

    @PluginMethod
    public void getUnreadConversationCount(PluginCall call) {
        Integer unreadCount = Intercom.client().getUnreadConversationCount();
        JSObject ret = new JSObject();
        ret.put("unreadCount", unreadCount);
        call.resolve(ret);
    }

    @PluginMethod
    public void sendPushTokenToIntercom(PluginCall call) {
        String token = call.getString("value");
        if (token == null || token.isEmpty()) {
            call.reject("value is missing or empty");
            return;
        }
        try {
            intercomPushClient.sendTokenToIntercom(this.getActivity().getApplication(), token);
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to send push token to Intercom", e);
        }
    }

    @PluginMethod
    public void receivePush(PluginCall call) {
        try {
            JSObject notificationData = call.getData();
            Map message = mapFromJSON(notificationData);
            if (intercomPushClient.isIntercomPush(message)) {
                intercomPushClient.handlePush(this.getActivity().getApplication(), message);
                call.resolve();
            } else {
                call.reject("Notification data was not a valid Intercom push message");
            }
        } catch (Exception e) {
            call.reject("Failed to handle received Intercom push", e);
        }
    }

    @PluginMethod
    public void setupUnreadConversationListener(PluginCall call) {
        Intercom.client().addUnreadConversationCountListener(this);
        call.resolve();
    }

    @PluginMethod
    public void removeUnreadConversationListener(PluginCall call) {
        Intercom.client().removeUnreadConversationCountListener(this);
        call.resolve();
    }

    @Override
    public void onCountUpdate(int i) {
        JSObject ret = new JSObject();
        ret.put("unreadCount", i);
        notifyListeners("updateUnreadCount", ret);
    }

    private void setUpIntercom() {
        try {
            // get config
            CapConfig config = this.bridge.getConfig();
            String apiKey = config.getPluginConfiguration("Intercom").getString("androidApiKey");
            String appId = config.getPluginConfiguration("Intercom").getString("androidAppId");

            // init intercom sdk
            Intercom.initialize(this.getActivity().getApplication(), apiKey, appId);
        } catch (Exception e) {
            Logger.error("Intercom", "ERROR: Something went wrong when initializing Intercom. Check your configurations", e);
        }
    }

    private static Map<String, Object> mapFromJSON(JSObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        Iterator<String> keysIter = jsonObject.keys();
        while (keysIter.hasNext()) {
            String key = keysIter.next();
            Object value = getObject(jsonObject.opt(key));
            if (value != null) {
                map.put(key, value);
            }
        }
        return map;
    }

    private static Object getObject(Object value) {
        if (value instanceof JSObject) {
            value = mapFromJSON((JSObject) value);
        } else if (value instanceof JSArray) {
            value = listFromJSON((JSArray) value);
        }
        return value;
    }

    private static List<Object> listFromJSON(JSArray jsonArray) {
        List<Object> list = new ArrayList<>();
        for (int i = 0, count = jsonArray.length(); i < count; i++) {
            Object value = getObject(jsonArray.opt(i));
            if (value != null) {
                list.add(value);
            }
        }
        return list;
    }
}
