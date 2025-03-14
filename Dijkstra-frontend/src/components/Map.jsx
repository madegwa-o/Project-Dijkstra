import React, { useEffect, useRef } from "react";
import * as d3 from "d3";

const Map = ({ coordinates }) => {
    const svgRef = useRef();

    useEffect(() => {
        const svg = d3.select(svgRef.current);

        // Clear any previous content
        svg.selectAll("*").remove();

        // Define dimensions
        const width = 400;
        const height = 500;
        const margin = { top: 40, right: 20, bottom: 20, left: 20 };

        // Scale functions for x and y positions
        const xScale = d3
            .scaleLinear()
            .domain(d3.extent(coordinates, (d) => d.x))
            .range([margin.left, width - margin.right]);

        const yScale = d3
            .scaleLinear()
            .domain(d3.extent(coordinates, (d) => d.y))
            .range([height - margin.bottom, margin.top]);

        // Draw lines between nodes
        svg
            .selectAll(".line")
            .data(coordinates.slice(1)) // Skip the first node for line connections
            .join("line")
            .attr("class", "line")
            .attr("x1", (d, i) => xScale(coordinates[i].x))
            .attr("y1", (d, i) => yScale(coordinates[i].y))
            .attr("x2", (d) => xScale(d.x))
            .attr("y2", (d) => yScale(d.y))
            .attr("stroke", "green")
            .attr("stroke-width", 2);

        // Draw nodes as circles
        svg
            .selectAll(".node")
            .data(coordinates)
            .join("circle")
            .attr("class", "node")
            .attr("cx", (d) => xScale(d.x))
            .attr("cy", (d) => yScale(d.y))
            .attr("r", 8)
            .attr("fill", "blue");

        // Add labels to nodes
        svg
            .selectAll(".label")
            .data(coordinates)
            .join("text")
            .attr("class", "label")
            .attr("x", (d) => xScale(d.x))
            .attr("y", (d) => yScale(d.y) - 12) // Position labels slightly above nodes
            .attr("text-anchor", "middle")
            .text((d) => d.label)
            .attr("font-size", 12)
            .attr("fill", "red");
    }, [coordinates]);

    return (
        <svg
            ref={svgRef}
            style={{
                width: "100%",
                height: "100%",
                border: "1px solid red",
            }}
        ></svg>
    );
};

export default Map;
