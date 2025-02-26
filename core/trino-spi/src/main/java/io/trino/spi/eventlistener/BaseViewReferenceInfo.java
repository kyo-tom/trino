/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.spi.eventlistener;

import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.requireNonNull;

/**
 * This class is JSON serializable for convenience and serialization compatibility is not guaranteed across versions.
 */
public abstract class BaseViewReferenceInfo
        implements TableReferenceInfo
{
    private final String catalogName;
    private final String schemaName;
    private final String viewName;

    protected BaseViewReferenceInfo(String catalogName, String schemaName, String viewName)
    {
        this.catalogName = requireNonNull(catalogName, "catalogName is null");
        this.schemaName = requireNonNull(schemaName, "schemaName is null");
        this.viewName = requireNonNull(viewName, "viewName is null");
    }

    @JsonProperty
    public String getCatalogName()
    {
        return catalogName;
    }

    @JsonProperty
    public String getSchemaName()
    {
        return schemaName;
    }

    @JsonProperty
    public String getViewName()
    {
        return viewName;
    }
}
