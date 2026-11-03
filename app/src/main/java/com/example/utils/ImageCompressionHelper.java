package com.example.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ImageCompressionHelper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/example/utils/ImageCompressionHelper;", "", "<init>", "()V", "MAX_DIMENSION", "", "TARGET_MAX_KB", "compressAndSaveFromUri", "", "context", "Landroid/content/Context;", "sourceUri", "Landroid/net/Uri;", "compressAndSaveFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "getPhotoSizeKb", "", "photoUriStr", "getShareableUri", "scaleToMaxDimension", "source", "maxDim", "applyExifRotation", "uri", "saveCompressedBitmap", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class ImageCompressionHelper {
    public static final int $stable = 0;
    public static final ImageCompressionHelper INSTANCE = new ImageCompressionHelper();
    private static final int MAX_DIMENSION = 960;
    private static final int TARGET_MAX_KB = 100;

    private ImageCompressionHelper() {
    }

    public final String compressAndSaveFromUri(Context context, Uri sourceUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream openInputStream = contentResolver.openInputStream(sourceUri);
            if (openInputStream != null) {
                InputStream inputStream = openInputStream;
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    if (decodeStream != null) {
                        int srcWidth = options.outWidth;
                        int srcHeight = options.outHeight;
                        if (srcWidth > 0 && srcHeight > 0) {
                            int inSampleSize = 1;
                            int maxDim = Math.max(srcWidth, srcHeight);
                            while (maxDim / (inSampleSize * 2) >= MAX_DIMENSION) {
                                inSampleSize *= 2;
                            }
                            BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
                            decodeOptions.inSampleSize = inSampleSize;
                            decodeOptions.inPreferredConfig = Bitmap.Config.RGB_565;
                            InputStream openInputStream2 = contentResolver.openInputStream(sourceUri);
                            if (openInputStream2 != null) {
                                inputStream = openInputStream2;
                                try {
                                    Bitmap sampledBitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptions);
                                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                                    if (sampledBitmap != null) {
                                        Bitmap orientedBitmap = applyExifRotation(context, sourceUri, sampledBitmap);
                                        Bitmap finalScaledBitmap = scaleToMaxDimension(orientedBitmap, MAX_DIMENSION);
                                        return saveCompressedBitmap(context, finalScaledBitmap);
                                    }
                                } finally {
                                    try {
                                        throw th;
                                    } finally {
                                    }
                                }
                            }
                            return null;
                        }
                        return null;
                    }
                } finally {
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String compressAndSaveFromBitmap(Context context, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            Bitmap finalScaledBitmap = scaleToMaxDimension(bitmap, MAX_DIMENSION);
            return saveCompressedBitmap(context, finalScaledBitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final long getPhotoSizeKb(Context context, String photoUriStr) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = photoUriStr;
        if (str == null || StringsKt.isBlank(str)) {
            return 0L;
        }
        try {
            if (!StringsKt.startsWith$default(photoUriStr, "/", false, 2, (Object) null) && !StringsKt.startsWith$default(photoUriStr, "file://", false, 2, (Object) null)) {
                Uri uri = Uri.parse(photoUriStr);
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                if (openFileDescriptor == null) {
                    return 0L;
                }
                ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor;
                try {
                    long statSize = parcelFileDescriptor.getStatSize() / 1024;
                    CloseableKt.closeFinally(parcelFileDescriptor, (Throwable) null);
                    return statSize;
                } finally {
                }
            }
            String cleanPath = StringsKt.startsWith$default(photoUriStr, "file://", false, 2, (Object) null) ? StringsKt.removePrefix(photoUriStr, "file://") : photoUriStr;
            File f = new File(cleanPath);
            if (f.exists()) {
                return f.length() / 1024;
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final Uri getShareableUri(Context context, String photoUriStr) {
        Uri parse;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = photoUriStr;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            String uriStr = StringsKt.trim(photoUriStr).toString();
            if (StringsKt.startsWith$default(uriStr, "content://", false, 2, (Object) null)) {
                String packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                if (StringsKt.contains$default(uriStr, packageName, false, 2, (Object) null)) {
                    return Uri.parse(uriStr);
                }
            }
            if (!StringsKt.startsWith$default(uriStr, "/", false, 2, (Object) null) && !StringsKt.startsWith$default(uriStr, "file://", false, 2, (Object) null)) {
                Uri srcUri = Uri.parse(uriStr);
                Intrinsics.checkNotNull(srcUri);
                String compressedUriStr = compressAndSaveFromUri(context, srcUri);
                return (compressedUriStr == null || (parse = Uri.parse(compressedUriStr)) == null) ? srcUri : parse;
            }
            String cleanPath = StringsKt.startsWith$default(uriStr, "file://", false, 2, (Object) null) ? StringsKt.removePrefix(uriStr, "file://") : uriStr;
            File file = new File(cleanPath);
            if (file.exists()) {
                return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final Bitmap scaleToMaxDimension(Bitmap source, int maxDim) {
        int width = source.getWidth();
        int height = source.getHeight();
        int currentMax = Math.max(width, height);
        if (currentMax <= maxDim) {
            return source;
        }
        float ratio = maxDim / currentMax;
        int targetWidth = RangesKt.coerceAtLeast((int) (width * ratio), 1);
        int targetHeight = RangesKt.coerceAtLeast((int) (height * ratio), 1);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        return createScaledBitmap;
    }

    private final Bitmap applyExifRotation(Context context, Uri uri, Bitmap bitmap) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                InputStream inputStream = openInputStream;
                try {
                    int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
                    Matrix matrix = new Matrix();
                    switch (attributeInt) {
                        case 3:
                            matrix.postRotate(180.0f);
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            break;
                        case 8:
                            matrix.postRotate(270.0f);
                            break;
                        default:
                            CloseableKt.closeFinally(inputStream, (Throwable) null);
                            return bitmap;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    if (createBitmap != null) {
                        return createBitmap;
                    }
                } finally {
                }
            }
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private final String saveCompressedBitmap(Context context, Bitmap bitmap) {
        File file = new File(context.getFilesDir(), "safety_evidence");
        if (!file.exists()) {
            file.mkdirs();
        }
        File destFile = new File(file, "hazard_evidence_" + System.currentTimeMillis() + ".jpg");
        int quality = 75;
        int attempt = 0;
        do {
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            try {
                FileOutputStream fileOutputStream2 = fileOutputStream;
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream2);
                fileOutputStream2.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                long fileSizeKb = destFile.length() / 1024;
                quality -= 10;
                attempt++;
                if (fileSizeKb <= 100 || quality < 45) {
                    break;
                }
            } finally {
            }
        } while (attempt < 4);
        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", destFile);
        return uri.toString();
    }
}
