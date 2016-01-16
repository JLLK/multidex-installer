# multidex-installer

A multidex library can help to install classes(..i).dex by the index number.

# Purpose

With google multidex library we can install all of secondary dexes or none of them. but with [multidex-installer](https://github.com/JLLK/multidex-installer) we'll have the capability of installing secondary dexes by their indexes, so we can decide which one and when to install at runtime.

There are three public static methods in `JLLKMultiDexInstaller`:

```java
	// Install all dexes in sourceApk
    public static void installAll(Context context)
    
    // Install one dex by index
    public static void installOne(Context context, int dexIndex)
    
    // Install dexes by range index
    public static void installRange(Context context, int startDexIndex, int endDexIndex)
```

Here is a sample of android project with the multidex-installer library:

multidex-sample: [https://github.com/JLLK/multidex-sample](https://github.com/JLLK/multidex-sample)

And there are some other things you can do with multidex-installer, [multidex-hook](https://github.com/JLLK/multidex-hook) and [multidex-maker](https://github.com/JLLK/multidex-maker), such as recording load-time of each module.

# Installation

`build.gradle`


```groovy
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile "com.github.jllk:multidex-installer:0.0.4-beta@aar"
}
```




`Application`:

```scala
class SampleApp extends Application {

  override def attachBaseContext(base: Context): Unit = {
    super.attachBaseContext(base)
    JLLKMultiDexInstaller.installOne(this, 2) // for R
    JLLKMultiDexInstaller.installRange(this, 3, 4) // for scala
  }
}
```

# License

This lib is licensed under Apache License 2.0. See LICENSE for details.