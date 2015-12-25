package com.github.jllk.multidex;

import android.content.Context;

/**
 * chentaov5@gmail.com
 * https://github.com/jllk
 */
public class JLLKMultiDexInstaller {

    /**
     *  Install all dexes in sourceApk
     *  @param context application context.
     * */
    public static void installAll(Context context) {
        checkNull(context);
        InstallValue.Builder builder = new InstallValue.Builder();
        builder.setType(InstallType.ALL);
        doInstall(context, builder.create());
    }

    /**
     * Install one dex by index
     * @param context application context.
     * @param dexIndex index of target dex
     * */
    public static void installOne(Context context, int dexIndex) {
        checkNull(context);
        InstallValue.Builder builder = new InstallValue.Builder();
        builder.setType(InstallType.ONE);
        builder.setDexIndex(dexIndex);
        doInstall(context, builder.create());
    }

    /**
     * install dexes by range index
     * @param context application context.
     * @param startDexIndex start index of target dexes
     * @param endDexIndex end index of target dexes
     * */
    public static void installRange(Context context, int startDexIndex, int endDexIndex) {
        checkNull(context);
        InstallValue.Builder builder = new InstallValue.Builder();
        builder.setType(InstallType.RANGE);
        builder.setStartDexIndex(startDexIndex);
        builder.setEndDexIndex(endDexIndex);
        doInstall(context, builder.create());
    }


    private static void doInstall(Context context, InstallValue value) {
        switch (value.type) {
            case ALL:
                JLLKMultiDex.install(context);
                break;
            case RANGE:
                JLLKMultiDex.install(context, value.startDexIndex, value.endDexIndex);
                break;
            case ONE:
                JLLKMultiDex.install(context, value.dexIndex);
                break;
            default:
                throw new IllegalArgumentException("[JLLKApplication] doInstall:  illegal args in InstallValue.type");
        }
    }


    private static void checkNull(Context context) {
        if (context == null)
            throw new IllegalArgumentException("[JLLKMultiDexInstaller] installAll context can't be null.");
    }


    private static class InstallValue {
        InstallType type;
        int startDexIndex;
        int endDexIndex;
        int dexIndex;

        public static class Builder {
            private final InstallValue V;

            public Builder() {
                V = new InstallValue();
            }

            public Builder setType(InstallType type) {
                V.type = type;
                return this;
            }

            public Builder setDexIndex(int dexIndex) {
                V.dexIndex = dexIndex;
                return this;
            }

            public Builder setStartDexIndex(int startDexIndex) {
                V.startDexIndex = startDexIndex;
                return this;
            }

            public Builder setEndDexIndex(int endDexIndex) {
                V.endDexIndex = endDexIndex;
                return this;
            }

            public InstallValue create() {
                return V;
            }
        }
    }


    private enum InstallType {
        ALL, RANGE, ONE,
    }
}
