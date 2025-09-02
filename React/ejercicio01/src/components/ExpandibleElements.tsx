import { useState } from "react";
import '../styles/ExpandibleElements.css';

type ExpandibleElement = {
    id: string,
    title: string,
    content: string
}

type ListOfExpandibleElements = ExpandibleElement[]

interface Props {
    expandibleElements: ListOfExpandibleElements;
}

export const Expandible: React.FC<Props> = ({ expandibleElements }) => {
    const [expandedId, setExpandedId] = useState<string | null>(null);

    const handleClick = (id: string) => {
        setExpandedId(currentId => currentId === id ? null : id);
    };

    return (
        <ul className="expandible-list">
            {expandibleElements.map(expandibleElement => (
                <li 
                    key={expandibleElement.id}
                    className={`expandible-item ${expandedId === expandibleElement.id ? 'expanded' : ''}`}
                    onClick={() => handleClick(expandibleElement.id)}
                >
                    <div className="expandible-header">
                        {expandibleElement.title}
                        <span className="arrow-icon">›</span>
                    </div>
                    <div className="expandible-content">
                        {expandibleElement.content}
                    </div>
                </li>
            ))}
        </ul>
    );
};