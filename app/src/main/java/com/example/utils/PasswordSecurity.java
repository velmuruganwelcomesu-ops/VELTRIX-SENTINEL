package com.example.utils;

import android.util.Base64;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PasswordSecurity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\u0019\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/utils/PasswordSecurity;", "", "<init>", "()V", "ITERATIONS", "", "KEY_LENGTH", "SALT_LENGTH", "PREFIX", "", "hashPassword", "password", "verifyPassword", "", "candidate", "stored", "isHashed", "pbkdf2", "", "", "salt", "iterations", "keyLength", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class PasswordSecurity {
    public static final int $stable = 0;
    public static final PasswordSecurity INSTANCE = new PasswordSecurity();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String PREFIX = "$pbkdf2$";
    private static final int SALT_LENGTH = 16;

    private PasswordSecurity() {
    }

    public final String hashPassword(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        byte[] hash = pbkdf2(charArray, salt, ITERATIONS, KEY_LENGTH);
        String saltB64 = Base64.encodeToString(salt, 2);
        String hashB64 = Base64.encodeToString(hash, 2);
        return "$pbkdf2$10000$" + saltB64 + "$" + hashB64;
    }

    public final boolean verifyPassword(String candidate, String stored) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(stored, "stored");
        if (StringsKt.isBlank(stored)) {
            return false;
        }
        if (!StringsKt.startsWith$default(stored, PREFIX, false, 2, (Object) null)) {
            return Intrinsics.areEqual(candidate, stored);
        }
        Iterable split$default = StringsKt.split$default(stored, new String[]{"$"}, false, 0, 6, (Object) null);
        Collection arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        List parts = (List) arrayList;
        if (parts.size() != 4 || !Intrinsics.areEqual(parts.get(0), "pbkdf2") || (intOrNull = StringsKt.toIntOrNull((String) parts.get(1))) == null) {
            return false;
        }
        int iterations = intOrNull.intValue();
        try {
            byte[] salt = Base64.decode((String) parts.get(2), 2);
            try {
                byte[] expectedHash = Base64.decode((String) parts.get(3), 2);
                char[] charArray = candidate.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                Intrinsics.checkNotNull(salt);
                byte[] candidateHash = pbkdf2(charArray, salt, iterations, KEY_LENGTH);
                return Arrays.equals(candidateHash, expectedHash);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public final boolean isHashed(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        return StringsKt.startsWith$default(password, PREFIX, false, 2, (Object) null);
    }

    private final byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] encoded = factory.generateSecret(spec).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return encoded;
    }
}
