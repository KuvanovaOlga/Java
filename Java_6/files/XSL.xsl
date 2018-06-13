<xsl:stylesheet version="1.0" xmlns="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="library">
        <xsl:copy>
            <xsl:for-each select="book">
                <xsl:sort select="cost"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
            <xsl:for-each select="booklet">
                <xsl:sort select="name"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
            <xsl:for-each select="magazine">
                <xsl:sort select="circulation"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>