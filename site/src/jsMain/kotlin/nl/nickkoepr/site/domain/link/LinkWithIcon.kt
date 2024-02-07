package nl.nickkoepr.site.domain.link

/**
 * Data class representing a Link with an icon.
 *
 * @param iconLocation location of the icon.
 * @param iconAlt alternative text for an icon (used by assistive technologies).
 * @param linkText display text for the link.
 * @param link link location (the user will be sent to this link).
 */
data class LinkWithIcon(val iconLocation: String, val iconAlt: String, val linkText: String, val link: String)
