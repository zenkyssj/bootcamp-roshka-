import { useState } from "react";
import '../styles/Label.css'

type LabelElements = {
    id: string,
    title: string,
    content: string
}

type ListOfLabelElements = LabelElements[]

interface LabelProps{
    labelElements: ListOfLabelElements;
}

export const Label: React.FC<LabelProps> = ({ labelElements }) =>{
    const [expandedIds, setExpandedIds] = useState<string[]>([]);

    const handleClick = (id: string) => {
        setExpandedIds(prevIds => 
            prevIds.includes(id)
                ? prevIds.filter(prevId => prevId !== id)
                : [...prevIds, id]
        );
    };

    return (
        <div className="label-container">
            {labelElements.map(labelElement => (
                <div
                    key={labelElement.id}
                    className={`label-item ${expandedIds.includes(labelElement.id) ? 'expanded' : ''}`}
                    onClick={() => handleClick(labelElement.id)}
                >
                    <div className="label-header">
                        <span className="label-title">{labelElement.title}</span>
                        <span className="toggle-icon">
                            {expandedIds.includes(labelElement.id) ? '−' : '+'}
                        </span>
                    </div>
                    <div className="label-content">
                        {labelElement.content}
                    </div>
                </div>
            ))}
        </div>
    )
}