# BlendleSDK
Open source Java SDK project for the website Blendle.com The SDK simplify backend communication for you, so you can focus on developing the app you want. Included is also the Android project ReaderKid that uses this library. ReaderKid is open source and is published in Google Play

[![ReaderKid on Google Play][google_play_link_image]
][google_play_link]

ReaderKid is a project that has been live since may 2014. And recently got a complete new design + fresh code and is now ready to be open source.

Feel free to contribute to both projects. If there are any feature request and or bugs please put them in the Github issues. This way we can track the issues, and refer to them in the merge requests.

##Usage SDK
#### Gradle

```java
repositories {
    maven { url "https://github.com/QVDev/BlendleSDK/raw/master/Android/SDK/releases/" }
}

dependencies {
    compile 'qvdev.utils.sdk.blendlesdk:blendleandroidsdk:x.x.x-SNAPSHOT'//x.x.x version
}
```
#### Project
```
// Initialize BlendleApi
BlendleApi blendleApi = new BlendleApi();

// Then execute the desired backend call example user fetching
mBlendleApi.getPublicUser(new Callback<User>() {
    @Override
    public void onResponse(Response<User> response, Retrofit retrofit) {
        if (response.isSuccess()) {
          User user = response.body();
          // Handle sucess response
        } else {
          // Handle non success responses
        }
    }

    @Override
    public void onFailure(Throwable t) {
        // Handle here failures
    }
}, "user");
```
Pretty straight forward. The SDK contains all necesary models and will be returned in the callback. Refresh token handling is also handled by the SDK. So on a 401 unauthorized response the SDK tries to authenticate. Of course you have to set the refresh token etc.. this can be done via.
```
// After user has logged in, make sure to make the SDK aware of the logged in user.
blendleApi.onUserLoggedIn(user);
```
Both projects using the MIT license. For more information see the [LICENSE](LICENSE) document.

Happy learning and developing!

QVDev TEAM!

[google_play_link]: https://play.google.com/store/apps/details?id=com.qvdev.apps.readerkid
[google_play_link_image]: https://developer.android.com/images/brand/en_app_rgb_wo_60.png "ReaderKid on Google Play"
