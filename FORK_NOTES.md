# Jellyfin-Fork notes

This fork uses the release application ID `org.jellyfin.androidtv.fork` and the display name **Jellyfin-Fork**. The debug variant uses `org.jellyfin.androidtv.fork.debug` and is named **Jellyfin-Fork Debug**. These IDs keep the fork installable alongside the official Android TV app with separate Android application data. Its server-side display-preference client key is also separate: `jellyfin-androidtv-fork`.

Recently Added Music Videos on the home screen inherit the standard home presenter's show-info, static-height, and uniform-aspect settings, while selecting landscape thumbnails. Both these items and Continue Watching episodes use static-height row items and a 16:9 aspect ratio, producing the same 266.67 × 150 dp thumbnail size. The episode-specific show-info override enables its preview; the Music Video presenter inherits the same enabled show-info setting. Preview text adds height below the thumbnail and is separate from these image dimensions.

Only Music Video cards in the Recently Added Music Video home row display `{Artists} - {SongTitle}`, using the item's `artists` metadata joined with commas and its normal card title. Empty or blank artist metadata falls back to the normal title. Item names and server metadata are unchanged.

Music Video library and artist-folder browsing uses landscape thumbnails by default, while still allowing the user to choose another supported image type. Music Video artist and folder cards show neither a title overlay nor a below-image preview. The upstream presenter has no existing label-free setting for these item types: disabling show-info normally enables their overlay instead. A scoped label-visibility predicate now gates both existing text paths without blanking item names. Music Videos inside folders keep their normal labels; focus, navigation, status overlays, and the selected-item metadata area remain unchanged.

Music Video artist-folder image type and card size settings use the shared `music-video-artists` display-preference ID. A change in one Music Video artist folder is therefore applied when opening another. Other library types, including ordinary Music libraries, retain their existing per-folder preference behavior.

The implementation intentionally reuses the app's current card presenter and display-preference store so it remains small and straightforward to merge with future Jellyfin Android TV updates.
