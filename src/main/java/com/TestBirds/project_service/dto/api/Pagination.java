package com.TestBirds.project_service.dto.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "A generic Pagination class for API responses.")
public class Pagination<T> {
    @ArraySchema(
        schema = @Schema(
            description = "The list of items for the current page."
        )
    )
    @JsonProperty("content")
    public List<T> content;

    @Schema(description = "The maximum number of items allowed per page.", example = "10")
    @JsonProperty("limit")
    public int limit;

    @Schema(description = "The offset of the current page (starting index).", example = "0")
    @JsonProperty("offset")
    public Long offset;

    @Schema(description = "The total number of items available.", example = "100")
    @JsonProperty("total")
    public Long total;

    @JsonCreator
    public Pagination(@JsonProperty("content") List<T> content,
                      @JsonProperty("limit") int limit,
                      @JsonProperty("offset") Long offset,
                      @JsonProperty("total") Long total) {
        this.content = content;
        this.limit = limit;
        this.offset = offset;
        this.total = total;
    }
}
