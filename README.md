# Rook Mod Menu — Android

Projeto Android Studio com interface demonstrativa independente.

## Gerar o APK pelo GitHub
1. Extraia este ZIP.
2. Crie um repositório no GitHub e envie o conteúdo da pasta `Rook_ModMenu_Android`.
3. Abra a aba **Actions** do repositório.
4. Execute **Build Android APK** (ou aguarde o build após enviar para `main`).
5. Abra a execução concluída, vá em **Artifacts** e baixe `rook-mod-menu-apk`.
6. Extraia o arquivo baixado: `app-debug.apk` é o instalador para Android.

## Gerar localmente
Abra a pasta no Android Studio (JDK 17 e Android SDK 35) e selecione
**Build > Build APK(s)**. O APK ficará em
`app/build/outputs/apk/debug/app-debug.apk`.

## Conteúdo e limites
Menu escuro/vermelho, botão expandir/recolher, switches demonstrativos e notificação
de teste. Os controles só alteram o estado visual local. O aplicativo não se conecta
ao Standoff 2 nem implementa aimbot, ESP, skin changer ou alteração de arquivos do jogo.
