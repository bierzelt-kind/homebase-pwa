# 🏠 LanDash - Play Store Setup Guide

## Was noch fehlt

### 1. Google Play Developer Account ($25 einmalig)
- Registriere dich unter: https://play.google.com/console
- Einmalige Gebühr: $25
- Verifizierung kann 2-3 Tage dauern

### 2. Signing-Keystore erstellen (einmalig)

```bash
# Terminal-Befehl:
keytool -genkey -v \
  -keystore landash-release.jks \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -alias landash
```

⚠️ **Merke dir das Passwort!**

### 3. GitHub Secrets einrichten

In GitHub → Repo → Settings → Secrets → Actions:

| Secret Name | Wert |
|---|---|
| `KEYSTORE_BASE64` | `base64 -w0 landash-release.jks` (Ausgabe dieses Befehls) |
| `KEYSTORE_PASSWORD` | Dein Keystore-Passwort |
| `KEY_ALIAS` | `landash` |
| `KEY_PASSWORD` | Dein Key-Passwort |

### 4. Play Store Listing vorbereiten

**App-Beschreibung (DE):**
```
LanDash - Dein Smart Home Dashboard

Verwalte alle deine lokalen Services an einem Ort. LanDash zeigt dir den Status deiner Smart Home Geräte, Media Server und mehr auf einen Blick an.

✨ Features:
• Übersichtliches Dashboard mit Status-Anzeige
• Home & Public Mode (lokal/extern)
• Schnelles Hinzufügen beliebter Services
• 100% lokal — keine Cloud, keine Tracker
• Offline-fähig
• Dunkles Design mit anpassbaren Farben
```

**App-Beschreibung (EN):**
```
LanDash - Your Smart Home Dashboard

Manage all your local services in one place. LanDash shows the status of your Smart Home devices, media servers and more at a glance.

✨ Features:
• Clean dashboard with live status indicators
• Home & Public mode (local/remote)
• Quick-add popular services
• 100% local — no cloud, no trackers
• Offline capable
• Dark theme with customizable colors
```

**Kategorie:** Tools / House & Home

### 5. Screenshots machen (mindestens 2)

Nach dem APK-Install auf dem Handy:
1. Dashboard mit Services (voll)
2. Settings / Quick-Add Panel
3. Optional: Edit/Delete Mode

### 6. Privacy Policy URL

Sobald die GitHub Pages Seite live ist:
https://bierzelt-kind.github.io/landash-pwa/privacy.html

---

## Build Status
- Debug APK: Wird bei jedem Push gebaut
- Release AAB: Wird gebaut wenn Secrets eingerichtet sind
- Artifacts: GitHub Actions → Download
