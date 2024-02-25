import React, { useEffect, useRef } from "react";
import { motion, useViewportScroll, useTransform } from "framer-motion";

const HorizontalTextAnimation = (props) => {
  const textRef1 = useRef(null);
  const textRef2 = useRef(null);
  const { text } = props;

  const duration = 20;
  const top = 1450;
  // Hook to get viewport scroll position
  const { scrollX } = useViewportScroll();

  // Transform scroll position to adjust horizontal position
  const xPos1 = useTransform(scrollX, [0, window.innerWidth], [-650, 650]);
  const xPos2 = useTransform(scrollX, [0, window.innerWidth], [-650, 650]);

  useEffect(() => {
    const handleScroll = () => {
      const textElement1 = textRef1.current;
      const textElement2 = textRef2.current;
      const rect1 = textElement1.getBoundingClientRect();
      const rect2 = textElement2.getBoundingClientRect();

      // Check if the first text element is outside the viewport
      if (rect1.right <= 0) {
        // Move the first text element to the end
        textElement1.style.transform = `translateX(100vw)`;
      }

      // Check if the second text element is outside the viewport
      if (rect2.left >= window.innerWidth) {
        // Move the second text element to the beginning
        textElement2.style.transform = `translateX(-100%)`;
      }
    };

    // Attach scroll event listener
    window.addEventListener("scroll", handleScroll);

    // Cleanup
    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, []);

  return (
    <>
      <motion.div
        ref={textRef1}
        className="animationChild"
        style={{
          overflow: "hidden", // Hides overflowing text
          whiteSpace: "nowrap", // Prevents text from wrapping
          position: "absolute",
          top: top, // Adjust as needed
          left: 0,
          x: xPos1, // Apply horizontal position transformation
        }}
        animate={{
          x: ["0.4%", "-100%"], // Start from left and end at right for the first text
        }}
        transition={{
          duration: duration, // Adjust duration as needed
          ease: "linear", // Linear easing for constant speed
          repeat: Infinity, // Repeat infinitely
        }}
      >
        <h1>{text}</h1>
      </motion.div>

      <motion.div
        ref={textRef2}
        className="animationChild"
        style={{
          overflow: "hidden", // Hides overflowing text
          whiteSpace: "nowrap", // Prevents text from wrapping
          position: "absolute",
          top: top, // Adjust as needed
          left: 0,
          x: xPos2, // Apply horizontal position transformation
        }}
        animate={{
          x: ["100%", "0.4%"], // Start from right and end at left for the second text
        }}
        transition={{
          duration: duration, // Adjust duration as needed
          ease: "linear", // Linear easing for constant speed
          repeat: Infinity, // Repeat infinitely
        }}
      >
        <h1>{text}</h1>
      </motion.div>
    </>
  );
};

export default HorizontalTextAnimation;
